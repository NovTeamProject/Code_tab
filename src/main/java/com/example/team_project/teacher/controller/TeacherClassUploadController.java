package com.example.team_project.teacher.controller;

import com.example.team_project.teacher.dao.ClassDAO;
import com.example.team_project.teacher.dto.ClassDTO;
import com.example.team_project.teacher.fileuploadutil.TeacherFileUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TeacherClassUploadController", value = "/teacher/class/upload")
@Slf4j
public class TeacherClassUploadController extends HttpServlet {

    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("TeacherClassUploadController doGet 호출");

        // 테스트 용으로 teacher_idx 값을 세션에 저장
        HttpSession session = req.getSession();
        session.setAttribute("teacher_idx", 1);

        req.getRequestDispatcher("/teacher/teacherClassUpload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("TeacherClassUploadController doPost 호출");
        // 테스트 용으로 teacher_idx 값을 세션에 저장
        HttpSession session = req.getSession();
        session.setAttribute("teacher_idx", 1);

        int teacherIdx = (Integer) session.getAttribute("teacher_idx");

        String className = req.getParameter("class-name");
        String classExplain = req.getParameter("class-explain");
        int classTotalLessonCount = Integer.parseInt(req.getParameter("class-total-lesson-count"));
        int classTotalTime = Integer.parseInt(req.getParameter("class-total-count"));

        // 강의 대표 사진 업로드
        String classImageUploadPath = req.getServletContext().getRealPath("/teacher/class-image");
        String classImageOriginalNameWithoutPath = null;
        String classImageSavedNameWithoutPath = null;
        try {
            classImageOriginalNameWithoutPath = TeacherFileUtil.uploadFile(req, classImageUploadPath);
            classImageSavedNameWithoutPath =
                    TeacherFileUtil.renameFile(classImageUploadPath, classImageOriginalNameWithoutPath);
        } catch (Exception e) {
            log.warn("선생님 강의 등록 - 강의 대표 이미지 업로드 오류 발생");
            alertLocation(resp, "강의 대표 사진 업로드 중 오류가 발생했습니다", req.getContextPath() + "/index.jsp");
            return;
        }

        // 일단 강의를 먼저 등록해야 수업에서 강의의 pk를 참조할 수 있다. 강의 먼저 등록
        ClassDTO classDTO = ClassDTO.builder()
                                    .className(className)
                                    .classExplain(classExplain)
                                    .teacherIdx(teacherIdx)
                                    .classTotalTime(classTotalTime)
                                    .classTotalLessonCount(classTotalLessonCount)
                                    .classPrice(0)
                                    .classImageOriginalFilename(classImageOriginalNameWithoutPath)
                                    .classImageSavedFilename(classImageSavedNameWithoutPath)
                                    .build();

        boolean result = classDAO.insertNewClass(classDTO);

        if (result) {
            log.info("TeacherClassUploadController - 새로운 강의 업로드 완료");
        } else {
            log.info("TeacherClassUploadController - 새로운 강의 업로드 실패");
        }

        // 각각의 수업 업로드
        for (int i = 1; i <= classTotalLessonCount; i++) {

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
}
