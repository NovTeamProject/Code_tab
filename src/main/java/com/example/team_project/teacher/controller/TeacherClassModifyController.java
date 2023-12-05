package com.example.team_project.teacher.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.class_gangui.dto.ClassDTO;
import com.example.team_project.lesson_sueop.dao.LessonDAO;
import com.example.team_project.lesson_sueop.dto.LessonDTO;
import com.example.team_project.teacher.fileuploadutil.TeacherFileUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TeacherClassModifyController", value = "/teacher/class/modify.do")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@Slf4j
public class TeacherClassModifyController extends HttpServlet {

    private ClassDAO classDAO = new ClassDAO();
    private LessonDAO lessonDAO = new LessonDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 테스트를 위해 임시로 teacher_idx의 값을 1로 설정
        HttpSession session = request.getSession();
        //session.setAttribute("teacher_idx", 1);
        // -------------------------------------------
        int teacherIdx = (Integer) session.getAttribute("teacherIdx");

        String classIdx = request.getParameter("classIdx");
        int classIdxInt = -1;

        if (classIdx == null || classIdx.isEmpty()) {
            alertLocation(response, "올바르지 않은 강의 번호입니다", request.getContextPath() + "/teacher/class/list.do");
            return;
        } else {
            try {
                classIdxInt = Integer.parseInt(classIdx.trim());
            } catch (Exception e) {
                alertLocation(response, "올바르지 않은 강의 번호입니다", request.getContextPath() + "/teacher/class/list.do");
                return;
            }
        }

        // 실제로 본인 강의가 맞는지 확인하는 작업
        int validCount = classDAO.checkIfSpecificTeacherIdxUploadedSpecificClassIdx(classIdxInt, teacherIdx);
        if (validCount != 1) {
            alertLocation(response, "본인이 등록한 강의만 수정할 수 있습니다", request.getContextPath() + "/teacher/class/list.do");
            return;
        }

        // 실제 본인 강의가 맞으니 계속 작업
        ClassDTO classDTO = classDAO.getOneClassInformationWithRelatedLessons(classIdxInt);
        request.setAttribute("classDTO", classDTO);
        request.getRequestDispatcher("/teacher/views/teacherClassModify.jsp")
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

        HttpSession session = request.getSession();
        int teacherIdx = (Integer) session.getAttribute("teacherIdx");
        int classIdx = Integer.parseInt(request.getParameter("class-idx"));

        // 실제로 본인 강의가 맞는지 확인하는 작업
        int validCount = classDAO.checkIfSpecificTeacherIdxUploadedSpecificClassIdx(classIdx, teacherIdx);
        if (validCount != 1) {
            alertLocation(response, "본인이 등록한 강의만 수정할 수 있습니다", request.getContextPath() + "/teacher/class/list.do");
            return;
        }

        // 강의 제목과 설명 그리고 사진이 변경됐다면 사진까지 업데이트 시킴
        ClassDTO classDTO = ClassDTO.builder()
                .classIdx(classIdx)
                .className(request.getParameter("class-name").trim())
                .classExplain(request.getParameter("class-explain").trim())
                .classTotalLessonCount(Integer.parseInt(request.getParameter("class-total-lesson-count")))
                .classTotalTime(Integer.parseInt(request.getParameter("class-total-time")))
                .build();

        // 강의 대표 사진이 변경됐는지 확인
        if (request.getParameter("class-image-modified").trim().equals("true")) {
            // 만약 변경 됐다면,
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
            classDTO.setClassImageOriginalFilename(classImageOriginalNameWithoutPath);
            classDTO.setClassImageSavedFilename(classImageSavedNameWithoutPath);

            // 데이터베이스에 수정된 강의 저장
            classDAO.updateClassWithClassImage(classDTO);
        } else {
            classDAO.updateClassWithoutClassImage(classDTO);
        }
        System.out.println("강의 수정 완료!");

        // 수업 업데이트
        int originalLessonCount = Integer.parseInt(request.getParameter("original-lesson-count"));
        int classTotalLessonCount = Integer.parseInt(request.getParameter("class-total-lesson-count"));
        String lessonVideoUploadPath = request.getServletContext().getRealPath("/teacher/lesson-video");

        for (int i = 1; i <= classTotalLessonCount; i++) {
            LessonDTO lessonDTO = LessonDTO.builder()
                    .lessonName(request.getParameter("lesson-name-" + i))
                    .classIdx(classIdx)
                    .lessonSequence(i)
                    .build();
            if (i <= originalLessonCount) {
                // 만약 원래 수업 count 이하라면, 원래 수업을 update 시켜줘야 함.
                // 동영상 파일을 업데이트 한 경우,
                String modified = request.getParameter("lesson-modified-" + i);
                if (modified.equals("true")) {
                    Part part = request.getPart("lesson-video-" + i);
                    String lessonOriginalFilename = TeacherFileUtil.lessonVideoUpload(part, lessonVideoUploadPath);
                    String lessonSavedFilename = TeacherFileUtil.renameFile(lessonVideoUploadPath, lessonOriginalFilename);
                    lessonDTO.setLessonOriginalFilename(lessonOriginalFilename);
                    lessonDTO.setLessonSavedFilename(lessonSavedFilename);
                    lessonDTO.setLessonTime(Integer.parseInt(request.getParameter("lesson-time-" + i)));
                    lessonDAO.updateLessonWithNewVideo(lessonDTO);
                } else {
                    lessonDAO.updateLessonWithoutNewVideo(lessonDTO);
                }
            } else {
                // 아니라면, 새로운 수업을 "insert" 해줘야 함.
                Part part = request.getPart("lesson-video-" + i);
                String lessonOriginalFilename = TeacherFileUtil.lessonVideoUpload(part, lessonVideoUploadPath);
                String lessonSavedFilename = TeacherFileUtil.renameFile(lessonVideoUploadPath, lessonOriginalFilename);
                lessonDTO.setLessonOriginalFilename(lessonOriginalFilename);
                lessonDTO.setLessonSavedFilename(lessonSavedFilename);
                lessonDTO.setLessonTime(Integer.parseInt(request.getParameter("lesson-time-" + i)));
                lessonDAO.insertNewLesson(lessonDTO);
            }
        }

        int updatedLessonCount = Integer.parseInt(request.getParameter("class-total-lesson-count"));
        if (originalLessonCount > updatedLessonCount) {
            // 필요 없는 수업 제거
            List<Integer> list = new ArrayList<>();
            for (int i = updatedLessonCount + 1; i <= originalLessonCount; i++) {
                list.add(i);
            }
            lessonDAO.removeUnnecessaryLessons(classIdx, list, originalLessonCount - updatedLessonCount);
        }
        alertLocation(response, "강의를 성공적으로 수정했습니다", request.getContextPath() + "/");
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
}
