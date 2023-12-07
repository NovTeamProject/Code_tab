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
import java.io.IOException;

@WebServlet("/teacherjoin.do")

public class TeacherJoinController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher(req.getContextPath() + "/membership/views/joinTeacher.jsp").forward(req, resp);
  }
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 회원 가입 (선생님)
    String teacherId = req.getParameter("teacherId");              // teacherId의 파라미터 값을 가져옴
    String teacherPassword = req.getParameter("teacherPassword");  // teacherPassword의 파라미터 값을 가져옴
    String teacherName = req.getParameter("teacherName");          // teacherName의 파라미터 값을 가져옴
    String checkTeacher = req.getParameter("checkTeacher");        // checkTeacher의 파라미터 값을 가져옴
    String teacherAddress = null;                                        // teacherAddress 객체 선언

    // 주소 입력
    if (req.getParameter("roadAddr")==null){
      // 주소가 도로명 주소일 경우
      teacherAddress = req.getParameter("roadAddr").concat("/").concat(req.getParameter("detailAddr"));
    }else {
      // 주소가 지번 주소일 경우
      teacherAddress = req.getParameter("jibunAddr").concat("/").concat(req.getParameter("detailAddr"));
    }
    
    // 승인코드 입력
    if(checkTeacher == null || !checkTeacher.equals("teacher")){
      JSFunction.alertBack(resp, "승인코드를 잘못입력하셨습니다. 관리자에게 문의주세요");
      return;
    }

    TeacherDTO tDto = new TeacherDTO();                              // TeacherDTO 객체 생성
    tDto.setTeacherId(teacherId);                                    // TeacherDTO 객체에 teacherId 저장
    tDto.setTeacherPassword(Encrypt.getEncrypt(teacherPassword));    // TeacherDTO 객체에 암호화된 teacherPassword 저장
    tDto.setTeacherName(teacherName);                                // TeacherDTO 객체에 teacherName 저장
    tDto.setTeacherAddress(teacherAddress);                          // TeacherDTO 객체에 teacherAddress 저장

    TeacherDAO tDao = new TeacherDAO();                              // TeacherDAO 객체 생성
    int result = tDao.joinTeacher(tDto);                             //  TeacherDAO 의 joinTeacher 메소드를 실행하여 값을 int 타입으로  result에 저장

    // 성공 or 실패
    if (result == 1) {
      JSFunction.alertLocation(resp, "회원가입에 성공했습니다.",req.getContextPath() + "/membership/views/loginTeacher.jsp");
    } else { //글쓰기 실패
      JSFunction.alertLocation(resp, "회원가입에 실패했습니다.",req.getContextPath() +"/membership/views/joinTeacher.jsp");
    }
  }
}

