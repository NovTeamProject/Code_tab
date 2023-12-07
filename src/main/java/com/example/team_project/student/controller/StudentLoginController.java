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

    Map<String, Object> map = new HashMap<String, Object>();                                            // Student 데이터를 저장할 HashMap 객체 생성
    StudentDAO sDao = new StudentDAO();                                                    // StudentDAO 객체 생성
    String studentId = req.getParameter("studentId");                                // studentId의 파라미터값을 가져옴
    String studentPassword = Encrypt.getEncrypt(req.getParameter("studentPassword"));  // studentPassword 값을 암호화 하여 저장
    String studentName = req.getParameter("studentName");                            //  studnetName의 파라미터값을 가져옴
    StudentDTO sDto = null;                                                                // StudentDTO 객체 선언


    if (studentId != null && studentPassword != null) {

      map.put("studentId", studentId);                                     // ID를 HashMap에 저장
      map.put("studentPassword", studentPassword);                         // 암호화된 비밀번호를 HashMap에 저장
      map.put("studentName", studentName);                                 // teacherName을 HashMap에 저장


    }
    boolean check = sDao.loginStudent(studentId,studentPassword);          // StudentDAO 의 LoginStudent 메소드를 실행하여 값을 boolean 타입으로  check에 저장

    if (check){
      sDto = sDao.idCheck(studentId);

      HttpSession session = req.getSession();        // 현재 세션 정보 가져옴
      if(session.isNew() || session.getAttribute("loginMember")==null) {

        session.setAttribute("loginMember", sDto);        // loginMember 를 세션에 저장
        session.setAttribute("studentIdx", sDto.getStudentIdx());          // studentIdx를 세션에 저장
        session.setAttribute("studentId", sDto.getStudentId());            // studnetId를 세션에 저장
        session.setAttribute("name", sDto.getStudentName());               // name을 세션에 저장
        session.setAttribute("personType",2); // 학생이면 2번, 선생0번

//        if(session.isNew())
        JSFunction.alertLocation(resp, "로그인에 성공했습니다.", req.getContextPath() + "/redirect_to_index.jsp");
      }
    }
    else {
      JSFunction.alertBack(resp, "아이디 또는 비밀번호가 틀립니다.");
    }
  }
}