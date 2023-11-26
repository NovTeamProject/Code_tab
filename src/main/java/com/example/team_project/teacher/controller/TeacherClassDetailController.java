package com.example.team_project.teacher.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.class_gangui.dto.ClassDTO;
import com.example.team_project.teacher.paging.Criteria;
import com.example.team_project.teacher.paging.PageMaker;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TeacherClassDetailController", value = "/teacher/class/detail.do")
@Slf4j
public class TeacherClassDetailController extends HttpServlet {

    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 테스트를 위해 임시로 teacher_idx의 값을 1로 설정
        HttpSession session = request.getSession();
        session.setAttribute("teacher_idx", 1);
        // -------------------------------------------
        int teacherIdx = (Integer) session.getAttribute("teacher_idx");
        int classIdx = Integer.parseInt(request.getParameter("classIdx"));

        ClassDTO classDTO = classDAO.getOneClassInformationWithRelatedLessons(classIdx);
        request.setAttribute("classDTO", classDTO);
        request.getRequestDispatcher("/teacher/views/teacherClassDetail.jsp")
                .forward(request, response);
    }
}
