package com.example.team_project.class_gangui.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.class_gangui.dto.ClassDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ClassController")
public class ClassController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ClassDAO classDAO = new ClassDAO();

        if ("register".equals(action)) {
            int classIdx = Integer.parseInt(request.getParameter("classIdx"));
            int studentIdx = Integer.parseInt(request.getParameter("studentIdx"));
            boolean result = classDAO.registerClass(classIdx, studentIdx);
            request.setAttribute("result", result ? "Registration Successful" : "Registration Failed");
        } else if ("cancel".equals(action)) {
            int classIdx = Integer.parseInt(request.getParameter("classIdx"));
            int studentIdx = Integer.parseInt(request.getParameter("studentIdx"));
            boolean result = classDAO.cancelClass(classIdx, studentIdx);
            request.setAttribute("result", result ? "Cancellation Successful" : "Cancellation Failed");
        } else if ("view".equals(action)) {
            int studentIdx = Integer.parseInt(request.getParameter("studentIdx"));
            List<ClassDTO> classList = classDAO.getRegisteredClasses(studentIdx);
            request.setAttribute("classList", classList);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
