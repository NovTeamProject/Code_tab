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


@WebServlet("/studentedit.do")
public class StudentEditController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher(req.getContextPath() + "/membership/views/editStudent.jsp").forward(req, resp);
  }
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    System.out.println("test");
    // 정보 수정 (학생)

    String studentPassword = req.getParameter("studentPassword");
    String studentName = req.getParameter("studentName");
    String studentAddress= null;

    if (req.getParameter("roadAddr")==null){
      studentAddress = req.getParameter("roadAddr").concat("/").concat(req.getParameter("detailAddr"));
    }else {
      studentAddress = req.getParameter("jibunAddr").concat("/").concat(req.getParameter("detailAddr"));
    }

    StudentDTO sDto = new StudentDTO();
    sDto.setStudentId((String) req.getSession().getAttribute("studentId"));
    sDto.setStudentPassword(Encrypt.getEncrypt(studentPassword));
    sDto.setStudentName(studentName);
    sDto.setStudentAddress(studentAddress);

    HttpSession session = req.getSession();
    session.setAttribute("loginMember", sDto);
    session.setAttribute("studentIdx", sDto.getStudentIdx());
    session.setAttribute("studentId", sDto.getStudentId());
    session.setAttribute("name", sDto.getStudentName());
    session.setAttribute("personType",2); // 학생이면 2번, 선생 0번


    StudentDAO sDao = new StudentDAO();
    int result = sDao.editStudent(sDto);

    // 성공 or 실패
    if (result == 1) {
      JSFunction.alertLocation(resp, "수정에 성공했습니다.",req.getContextPath() + "/redirect_to_index.jsp");
    } else { //실패
      JSFunction.alertLocation(resp, "수정에 실패했습니다.",req.getContextPath() +"/redirect_to_index.jsp");
    }
  }
}


