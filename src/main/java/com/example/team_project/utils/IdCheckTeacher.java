package com.example.team_project.utils;

import com.example.team_project.teacher.dao.TeacherDAO;
import com.example.team_project.teacher.dto.TeacherDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/IdCheckTeacher.do")
public class IdCheckTeacher extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    req.getRequestDispatcher("${pageContext.request.contextPath}/membership/views/joinStudent.jsp").forward(req, resp);
    req.getRequestDispatcher(req.getContextPath() + "/membership/views/joinTeacher.jsp").forward(req, resp);
  }
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String teacherId = req.getParameter("teacherId");
    TeacherDAO tDao = new TeacherDAO();
    TeacherDTO result = tDao.idCheck(teacherId);

    if (result == null ) {

      resp.setContentType("application/json");
      resp.getWriter().print("{\"result\": true}");
    } else {

      resp.setContentType("application/json");
      resp.getWriter().print("{\"result\": false}");
    }

  }
}