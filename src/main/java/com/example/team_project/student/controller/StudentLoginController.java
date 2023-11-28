package com.example.team_project.student.controller;

import com.example.team_project.student.dao.StudentDAO;
import com.example.team_project.student.dto.StudentDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet( "/loginstudent.do")
public class StudentLoginController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String studentId = req.getParameter("studentId");
    String studentPassword = req.getParameter("studentPassword");
    StudentDAO sDao = new StudentDAO();

    Map<String, String> studentMap = new HashMap<>();
    studentMap.put("studentId", studentId);
    studentMap.put("studentPassword", studentPassword);

    List<StudentDTO> studentlist = sDao.loginStudent(studentMap);

    if (!studentlist.isEmpty()) {
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
      dispatcher.forward(req, resp);
    } else {
      req.setAttribute("error", "회원정보가 없습니다..");
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
      dispatcher.forward(req, resp);
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("login.jsp");
  }
}
