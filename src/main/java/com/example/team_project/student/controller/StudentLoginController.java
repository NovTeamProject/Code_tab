package com.example.team_project.student.controller;

import com.example.team_project.student.dao.StudentDAO;
import com.example.team_project.student.dto.StudentDTO;
import com.example.team_project.utils.Encrypt;
import com.example.team_project.utils.JSFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet( "/loginstudent.do")
public class StudentLoginController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Map<String, Object> map = new HashMap<String, Object>();
    StudentDAO dao = new StudentDAO();
    String studentId = req.getParameter("studentId");
    String studentPassword = Encrypt.getEncrypt(req.getParameter("studentPassword"));
    System.out.println(studentPassword);
    StudentDTO sDto = null;

    if (studentId != null && studentPassword != null) {

      map.put("studentId", studentId);
      map.put("studentPassword", studentPassword);

    }
    boolean check = dao.loginStudent(studentId,studentPassword);

    if (check){
      sDto = dao.idCheck(studentId);
      HttpSession session = req.getSession();
      if(session.isNew() || session.getAttribute("loginMember")==null) {
        session.setAttribute("loginMember", sDto);
//        if(session.isNew())
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
      }
    }
    else {
      JSFunction.alertBack(resp, "비밀번호 검증에 실패했습니다.");
    }
  }
}
