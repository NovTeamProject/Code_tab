package com.example.team_project.teacher.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.lesson_sueop.dao.LessonDAO;
import com.example.team_project.class_gangui.dto.ClassDTO;
import com.example.team_project.lesson_sueop.dto.LessonDTO;
import com.example.team_project.teacher.fileuploadutil.TeacherFileUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TeacherClassUploadController", value = "/teacher/class/upload.do")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 500,
        maxRequestSize = 1024 * 1024 * 500
)
@Slf4j
public class TeacherClassUploadController extends HttpServlet {

    private ClassDAO classDAO = new ClassDAO();
    private LessonDAO lessonDAO = new LessonDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("TeacherClassUploadController doGet 호출");

        // 테스트 용으로 teacher_idx 값을 세션에 저장
//        HttpSession session = req.getSession();
//        session.setAttribute("teacher_idx", 1);

        boolean check = TeacherLoginCheck.checkIfTeacherLogined(request);
        if (check == false) {
            alertLocation(response, "선생님으로 로그인 후 이용할 수 있습니다",
                    request.getContextPath() + "/membership/loginTeacher.jsp");
            return;
        }

        request.getRequestDispatcher("/teacher/views/teacherClassUpload.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("TeacherClassUploadController doPost 호출");

        boolean check = TeacherLoginCheck.checkIfTeacherLogined(request);
        if (check == false) {
            alertLocation(response, "선생님으로 로그인 후 이용할 수 있습니다",
                    request.getContextPath() + "/membership/loginTeacher.jsp");
            return;
        }

        // 테스트 용으로 teacher_idx 값을 세션에 저장
        HttpSession session = request.getSession();
        //session.setAttribute("teacher_idx", 1);

        int teacherIdx = (Integer) session.getAttribute("teacherIdx");

        String className = request.getParameter("class-name");
        String classExplain = request.getParameter("class-explain");
        int classTotalLessonCount = Integer.parseInt(request.getParameter("class-total-lesson-count"));
        int classTotalTime = Integer.parseInt(request.getParameter("class-total-time"));

        // 강의 대표 사진 업로드
        String classImageUploadPath = request.getServletContext().getRealPath("/teacher/class-image");
        String classImageOriginalNameWithoutPath = null;
        String classImageSavedNameWithoutPath = null;
        try {
            classImageOriginalNameWithoutPath = TeacherFileUtil.classImageUpload(request, classImageUploadPath);
            classImageSavedNameWithoutPath =
                    TeacherFileUtil.renameFile(classImageUploadPath, classImageOriginalNameWithoutPath);
        } catch (Exception e) {
            log.warn("선생님 강의 등록 - 강의 대표 이미지 업로드 오류 발생");
            alertLocation(response, "강의 대표 사진 업로드 중 오류가 발생했습니다", request.getContextPath() + "/index.jsp");
            return;
        }

        // 일단 강의를 먼저 등록해야 수업에서 강의의 pk를 참조할 수 있다. 강의 먼저 등록
        ClassDTO classDTO = ClassDTO.builder()
                                    .className(className)
                                    .classExplain(classExplain)
                                    .teacherIdx(teacherIdx)
                                    .classTotalTime(classTotalTime)
                                    .classTotalLessonCount(classTotalLessonCount)
                                    .classImageOriginalFilename(classImageOriginalNameWithoutPath)
                                    .classImageSavedFilename(classImageSavedNameWithoutPath)
                                    .build();

        boolean classInsertResult = classDAO.insertNewClass(classDTO);

        if (classInsertResult) {
            log.info("TeacherClassUploadController - 새로운 강의 업로드 완료 - 강의번호: {}", classDTO.getClassIdx());
        } else {
            log.info("TeacherClassUploadController - 새로운 강의 업로드 실패");
        }

        try {
            String lessonVideoUploadPath = request.getServletContext().getRealPath("/teacher/lesson-video");

            // 각각의 수업 업로드
            for (int i = 1; i <= classTotalLessonCount; i++) {
                String lessonName = request.getParameter("lesson-name-" + i);
                int lessonTime = Integer.parseInt(request.getParameter("lesson-time-" + i));

                Part part = request.getPart("lesson-video-" + i);
                String lessonOriginalFilename = TeacherFileUtil.lessonVideoUpload(part, lessonVideoUploadPath);
                String lessonSavedFilename = TeacherFileUtil.renameFile(lessonVideoUploadPath, lessonOriginalFilename);
                LessonDTO lessonDTO = LessonDTO.builder()
                                            .lessonName(lessonName)
                                            .lessonTime(lessonTime)
                                            .lessonOriginalFilename(lessonOriginalFilename)
                                            .lessonSavedFilename(lessonSavedFilename)
                                            .lessonSequence(i)
                                            .classIdx(classDTO.getClassIdx())
                                            .build();
                boolean lessonInsertResult = lessonDAO.insertNewLesson(lessonDTO);
                if (lessonInsertResult) {
                    log.info("TeacherClassUploadController - 강의번호 {}번에 대한 수업번호{} 저장 성공",
                            classDTO.getClassIdx(), lessonDTO.getLessonIdx());
                    log.info("----------");
                } else {
                    log.info("TeacherClassUploadController - 강의번호 {}번에 대한 수업 저장 실패",
                            classDTO.getClassIdx());
                    alertBack(response, "새로운 강의 등록 중 오류 발생");
                }
            }
            // 모든 수업 정상적으로 등록 완료 시
            alertLocation(response, "새로운 강의를 등록했습니다", request.getContextPath() + "/teacher/class/list.do");
        } catch (Exception e) {
            log.info("강의 번호: {} - 수업 업로드 중 오류 발생", classDTO.getClassIdx());
            log.info(e.getMessage());
            alertBack(response, "새로운 강의 등록 중 오류 발생");
        }
    }

    private void alertLocation(HttpServletResponse resp, String msg, String url) {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            String script = "<script>"
                    + "    alert('" + msg + "');"
                    + "    location.href='" + url + "';"
                    + "</script>";
            writer.print(script);
            writer.flush();
            writer.close();
        }
        catch (Exception e) {}
    }

    public static void alertBack(HttpServletResponse resp, String msg) {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            String script = "<script>"
                    + "    alert('" + msg + "');"
                    + "    history.back();"
                    + "</script>";
            writer.print(script);
            writer.flush();
            writer.close();
        }
        catch (Exception e) {}
    }
}
