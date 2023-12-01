<<<<<<< HEAD
<<<<<<<< HEAD:src/main/java/com/example/team_project/utils/IdCheckStudent.java
package com.example.team_project.utils;

import com.example.team_project.student.dao.StudentDAO;
import com.example.team_project.student.dto.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/IdCheck.do")
public class IdCheckStudent extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    req.getRequestDispatcher("${pageContext.request.contextPath}/membership/views/joinStudent.jsp").forward(req, resp);
    req.getRequestDispatcher(req.getContextPath() + "/membership/views/joinStudent.jsp").forward(req, resp);
  }
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String studentId = req.getParameter("studentId");
    StudentDAO sDao = new StudentDAO();
    StudentDTO result = sDao.idCheck(studentId);

    if (result == null ) {

      resp.setContentType("application/json");
      resp.getWriter().print("{\"result\": true}");
    } else {

      resp.setContentType("application/json");
      resp.getWriter().print("{\"result\": false}");
    }

  }
}
========
=======
>>>>>>> 007d1a7bc15ff8105b02ce2eef816b13cfc353cd
package com.example.team_project.utils;

import com.example.team_project.student.dao.StudentDAO;
import com.example.team_project.student.dto.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/IdCheck.do")
<<<<<<< HEAD
public class IdCheck extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    req.getRequestDispatcher("${pageContext.request.contextPath}/membership/views/join2.jsp").forward(req, resp);
=======
public class IdCheckStudent extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    req.getRequestDispatcher("${pageContext.request.contextPath}/membership/views/joinStudent.jsp").forward(req, resp);
>>>>>>> 007d1a7bc15ff8105b02ce2eef816b13cfc353cd
    req.getRequestDispatcher(req.getContextPath() + "/membership/views/joinStudent.jsp").forward(req, resp);
  }
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String studentId = req.getParameter("studentId");
    StudentDAO sDao = new StudentDAO();
    StudentDTO result = sDao.idCheck(studentId);

    if (result == null ) {

      resp.setContentType("application/json");
      resp.getWriter().print("{\"result\": true}");
    } else {

      resp.setContentType("application/json");
      resp.getWriter().print("{\"result\": false}");
    }

  }
<<<<<<< HEAD
}
>>>>>>>> 007d1a7bc15ff8105b02ce2eef816b13cfc353cd:src/main/java/com/example/team_project/utils/IdCheck.java
=======
}
>>>>>>> 007d1a7bc15ff8105b02ce2eef816b13cfc353cd
