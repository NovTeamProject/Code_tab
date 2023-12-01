<<<<<<< HEAD
<<<<<<<< HEAD:src/main/java/com/example/team_project/utils/IdCheckTeacher.java
package com.example.team_project.utils;

import com.example.team_project.teacher.dao.TeacherDAO;
import com.example.team_project.teacher.dto.TeacherDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/IdCheck2.do")
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
========
package com.example.team_project.utils;

import com.example.team_project.student.dao.StudentDAO;
import com.example.team_project.student.dto.StudentDTO;
=======
package com.example.team_project.utils;

>>>>>>> 007d1a7bc15ff8105b02ce2eef816b13cfc353cd
import com.example.team_project.teacher.dao.TeacherDAO;
import com.example.team_project.teacher.dto.TeacherDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/IdCheck2.do")
<<<<<<< HEAD
public class IdCheck2 extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    req.getRequestDispatcher("${pageContext.request.contextPath}/membership/views/join2.jsp").forward(req, resp);
=======
public class IdCheckTeacher extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    req.getRequestDispatcher("${pageContext.request.contextPath}/membership/views/joinStudent.jsp").forward(req, resp);
>>>>>>> 007d1a7bc15ff8105b02ce2eef816b13cfc353cd
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
<<<<<<< HEAD
}
>>>>>>>> 007d1a7bc15ff8105b02ce2eef816b13cfc353cd:src/main/java/com/example/team_project/utils/IdCheck2.java
=======
}
>>>>>>> 007d1a7bc15ff8105b02ce2eef816b13cfc353cd
