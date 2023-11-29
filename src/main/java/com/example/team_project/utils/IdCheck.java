package com.example.team_project.utils;

import com.example.team_project.student.dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/IdCheck.do")
public class IdCheck extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    req.getRequestDispatcher("${pageContext.request.contextPath}/membership/views/join2.jsp").forward(req, resp);
    req.getRequestDispatcher(req.getContextPath() + "/membership/views/join2.jsp").forward(req, resp);
  }
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/*    String studentId = req.getParameter("studentId");
    StudentDAO sDao = new StudentDAO();
    boolean result = sDao.idCheck(studentId);
    System.out.println(result);
    if (result == true) {

      resp.getWriter().print("1");
    } else {
      resp.getWriter().print("2");
    }*/
  }
}