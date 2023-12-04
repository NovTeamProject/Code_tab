package com.example.team_project.student.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(value = "/student/myClass/delete.do")
public class StudentClassDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentIdx = (Integer)req.getSession().getAttribute("studentIdx");
        int classIdx = Integer.parseInt(req.getParameter("classIdx"));

        boolean successfullyDeleted = classDAO.deleteClass(classIdx, studentIdx);

        if (successfullyDeleted) {
            // 수강신청한 학생에서 -1
            int result = classDAO.minusOneStudent(classIdx);
            resp.getWriter().write("success");
        } else {
            resp.getWriter().write("failure");
        }
    }
}
