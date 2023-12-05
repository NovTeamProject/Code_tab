package com.example.team_project.student.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.utils.JSFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/student/myClass/register.do")
public class StudentClassRegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentIdx = (Integer)req.getSession().getAttribute("studentIdx");
        int classIdx = Integer.parseInt(req.getParameter("classIdx"));

        boolean isAlreadyRegistered = classDAO.checkIfStudentRegisteredClass(classIdx, studentIdx);
        boolean successfullyRegistered = false;

        if (isAlreadyRegistered) {
            resp.getWriter().write("already_registered");
            return;
        } else {
            successfullyRegistered = classDAO.registerClass(classIdx, studentIdx);
        }

        if (successfullyRegistered) {
            // 수강신청한 학생수 +1
            int result = classDAO.plusOneStudent(classIdx);
            resp.getWriter().write("success");
        } else {
            resp.getWriter().write("failure");
        }
    }
}