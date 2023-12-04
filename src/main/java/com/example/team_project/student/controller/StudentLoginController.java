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
    StudentDAO sDao = new StudentDAO();
    String studentId = req.getParameter("studentId");
    String studentPassword = Encrypt.getEncrypt(req.getParameter("studentPassword"));
    String studentName = req.getParameter("studentName");
    StudentDTO sDto = null;


    if (studentId != null && studentPassword != null) {

      map.put("studentId", studentId);
      map.put("studentPassword", studentPassword);
      map.put("studentName", studentName);


    }
    boolean check = sDao.loginStudent(studentId,studentPassword);

    if (check){
      sDto = sDao.idCheck(studentId);

      HttpSession session = req.getSession();
      if(session.isNew() || session.getAttribute("loginMember")==null) {

        session.setAttribute("loginMember", sDto);
        session.setAttribute("studentIdx", sDto.getStudentIdx());
        session.setAttribute("studentId", sDto.getStudentId());
        session.setAttribute("name", sDto.getStudentName());
        session.setAttribute("personType",2); // 학생이면 2번, 선생0번

//        if(session.isNew())
        JSFunction.alertLocation(resp, "로그인에 성공했습니다.", req.getContextPath() + "/index.jsp");
      }
    }
    else {
      JSFunction.alertBack(resp, "아이디 또는 비밀번호가 틀립니다.");
    }
  }
}