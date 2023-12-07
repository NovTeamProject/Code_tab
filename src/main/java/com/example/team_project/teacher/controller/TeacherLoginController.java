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

    Map<String, Object> map = new HashMap<String, Object>();       // Teacher 데이터를 저장할 HashMap 객체 생성
    TeacherDAO tDao = new TeacherDAO();                            // TeacherDAO 객체 생성
    String teacherId = req.getParameter("teacherId");        // teacherId의 파라미터값을 가져옴
    String teacherPassword = Encrypt.getEncrypt(req.getParameter("teacherPassword"));  // teacherPassword 값을 암호화 하여 저장
    String teacherName = req.getParameter("teacherName");    //  teacherName의 파라미터값을 가져옴
    TeacherDTO tDto = null;                                        // TeacherDTO 객체 선언


    if (teacherId != null && teacherPassword != null) {

      map.put("teacherId", teacherId);                               // ID를 HashMap에 저장
      map.put("teacherPassword", teacherPassword);                   // 암호화된 비밀번호를 HashMap에 저장
      map.put("teacherName", teacherName);                           // teacherName을 HashMap에 저장

    }
    boolean check = tDao.loginTeacher(teacherId,teacherPassword);    // TeacherDAO 의 LoginTeacher 메소드를 실행하여 값을 boolean 타입으로  check에 저장

    if (check){
      tDto = tDao.idCheck(teacherId);
      HttpSession session = req.getSession();     // 현재 세션 정보 가져옴
      if(session.isNew() || session.getAttribute("loginMember")==null) {
        session.setAttribute("loginMember", tDto);      // loginMember 를 세션에 저장
        session.setAttribute("teacherIdx", tDto.getTeacherIdx());    // teacherIdx를 세션에 저장
        session.setAttribute("teacherId",  tDto.getTeacherId());     // teacherId를 세션에 저장
        session.setAttribute("name", tDto.getTeacherName());         // name을 세션에 저장
        session.setAttribute("personType",0); // 학생이면 2번, 선생이면 0번으로 설정하여 세션에 저장
//        if(session.isNew())
        JSFunction.alertLocation(resp, "로그인에 성공했습니다.", req.getContextPath() + "/redirect_to_index.jsp");
      }
    }
    else {
      JSFunction.alertBack(resp, "아이디 또는 비밀번호가 틀립니다.");
    }
  }
}