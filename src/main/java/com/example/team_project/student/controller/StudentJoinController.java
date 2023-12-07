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
import java.io.IOException;

@WebServlet("/studentjoin.do")

public class StudentJoinController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher(req.getContextPath() + "/membership/views/joinStudent.jsp").forward(req, resp);
  }
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 회원 가입 (학생)
    String studentId = req.getParameter("studentId");                      // studentId의 파라미터 값을 가져옴
    String studentPassword = req.getParameter("studentPassword");          // studentPassword의 파라미터 값을 가져옴
    String studentName = req.getParameter("studentName");                  // studentName의 파라미터 값을 가져옴
    String studentAddress= null;                                                 // studentAddress 객체 선언

    // 주소 입력
    if (req.getParameter("roadAddr")==null){
      // 주소가 도로명 주소일 경우
      studentAddress = req.getParameter("roadAddr").concat("/").concat(req.getParameter("detailAddr"));
    }else {
      // 주소가 지번 주소일 경우
      studentAddress = req.getParameter("jibunAddr").concat("/").concat(req.getParameter("detailAddr"));
    }


    StudentDTO sDto = new StudentDTO();                                  // StudentDTO 객체 생성
    sDto.setStudentId(studentId);                                        // StudentDTO 객체에 studentId 저장
    sDto.setStudentPassword(Encrypt.getEncrypt(studentPassword));        // StudentDTO 객체에 암호화된 studentPassword 저장
    sDto.setStudentName(studentName);                                    // StudentDTO 객체에 studentName 저장
    sDto.setStudentAddress(studentAddress);                              // StudentDTO 객체에 studentAddress 저장

    StudentDAO sDao = new StudentDAO();                                  // StudentDAO 객체 생성
    int result = sDao.joinStudent(sDto);                                 //  StudentDAO 의 joinStudent 메소드를 실행하여 값을 int 타입으로  result에 저장

    // 성공 or 실패
    if (result == 1) {
      JSFunction.alertLocation(resp, "회원가입에 성공했습니다.",req.getContextPath() + "/membership/views/loginStudent.jsp");
    } else { //회원가입 실패
      JSFunction.alertLocation(resp, "회원가입에 실패했습니다.",req.getContextPath() +"/membership/views/joinStudent.jsp");
    }
  }
}

