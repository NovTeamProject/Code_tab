package com.example.team_project.teacher.controller;

import com.example.team_project.teacher.dao.TeacherDAO;
import com.example.team_project.teacher.dto.TeacherDTO;
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

@WebServlet( "/loginteacher.do")
public class TeacherLoginController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Map<String, Object> map = new HashMap<String, Object>();
    TeacherDAO tDao = new TeacherDAO();
    String teacherId = req.getParameter("teacherId");
    String teacherPassword = Encrypt.getEncrypt(req.getParameter("teacherPassword"));
    String teacherName = req.getParameter("teacherName");
    TeacherDTO tDto = null;


    if (teacherId != null && teacherPassword != null) {

      map.put("teacherId", teacherId);
      map.put("teacherPassword", teacherPassword);
      map.put("teacherName", teacherName);

    }
    boolean check = tDao.loginTeacher(teacherId,teacherPassword);

    if (check){
      tDto = tDao.idCheck(teacherId);
      HttpSession session = req.getSession();
      if(session.isNew() || session.getAttribute("loginMember")==null) {
        session.setAttribute("loginMember", tDto);
        session.setAttribute("teacherIdx", tDto.getTeacherIdx());
        session.setAttribute("teacherId",  tDto.getTeacherId());
        session.setAttribute("name", tDto.getTeacherName());
        session.setAttribute("personType",0); // 학생이면 2번, 선생이면 0번
//        if(session.isNew())
        JSFunction.alertLocation(resp, "로그인에 성공했습니다.", req.getContextPath() + "/index.jsp");
      }
    }
    else {
      JSFunction.alertBack(resp, "아이디 또는 비밀번호가 틀립니다.");
    }
  }
}
