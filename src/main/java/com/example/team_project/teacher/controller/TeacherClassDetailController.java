package com.example.team_project.teacher.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.class_gangui.dto.ClassDTO;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TeacherClassDetailController", value = "/teacher/class/detail.do")
@Slf4j
public class TeacherClassDetailController extends HttpServlet {

    private ClassDAO classDAO = new ClassDAO();

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
            alertLocation(response, "본인이 등록한 강의만 상세 조회할 수 있습니다", request.getContextPath() + "/teacher/class/list.do");
            return;
        }

        // 실제 본인 강의가 맞으니 계속 작업
        ClassDTO classDTO = classDAO.getOneClassInformationWithRelatedLessons(classIdxInt);
        request.setAttribute("classDTO", classDTO);
        request.getRequestDispatcher("/teacher/views/teacherClassDetail.jsp")
                .forward(request, response);
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
