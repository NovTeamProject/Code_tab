package com.example.team_project.teacher.controller;

import com.example.team_project.teacher.dao.TeacherDAO;
import com.example.team_project.teacher.dto.TeacherDTO;

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



@WebServlet( "/loginteacher.do")
public class TeacherLoginController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String teacherId = req.getParameter("teacherId");
    String teacherPassword = req.getParameter("teacherPassword");
    TeacherDAO tDao = new TeacherDAO();

    Map<String, String> teacherMap = new HashMap<>();
    teacherMap.put("studentId", teacherId);
    teacherMap.put("studentPassword", teacherPassword);

    List<TeacherDTO> teacherlist = tDao.loginTeacher(teacherMap);

    if (!teacherlist.isEmpty()) {
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
