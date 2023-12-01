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
    String studentId = req.getParameter("studentId");
    String studentPassword = req.getParameter("studentPassword");
    String studentName = req.getParameter("studentName");

    StudentDTO sDto = new StudentDTO();
    sDto.setStudentId(studentId);
    sDto.setStudentPassword(Encrypt.getEncrypt(studentPassword));
    sDto.setStudentName(studentName);

    StudentDAO sDao = new StudentDAO();
    int result = sDao.joinStudent(sDto);

    // 성공 or 실패
    if (result == 1) {
      JSFunction.alertLocation(resp, "회원가입에 성공했습니다.",req.getContextPath() + "/membership/views/loginStudent.jsp");
    } else { //회원가입 실패
      JSFunction.alertLocation(resp, "회원가입에 실패했습니다.",req.getContextPath() +"/membership/views/joinStudent.jsp");
    }
  }
}

