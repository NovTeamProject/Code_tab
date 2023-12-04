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
    String teacherId = req.getParameter("teacherId");
    String teacherPassword = req.getParameter("teacherPassword");
    String teacherName = req.getParameter("teacherName");
    String teacherAddress = null;

    if (req.getParameter("roadAddr")==null){
      teacherAddress = req.getParameter("roadAddr").concat("/").concat(req.getParameter("detailAddr"));
    }else {
      teacherAddress = req.getParameter("jibunAddr").concat("/").concat(req.getParameter("detailAddr"));
    }

    TeacherDTO tDto = new TeacherDTO();
    tDto.setTeacherId(teacherId);
    tDto.setTeacherPassword(Encrypt.getEncrypt(teacherPassword));
    tDto.setTeacherName(teacherName);
    tDto.setTeacherAddress(teacherAddress);

    System.out.println(tDto);
    TeacherDAO tDao = new TeacherDAO();
    int result = tDao.joinTeacher(tDto);

    // 성공 or 실패
    if (result == 1) {
      JSFunction.alertLocation(resp, "회원가입에 성공했습니다.",req.getContextPath() + "/membership/views/loginTeacher.jsp");
    } else { //글쓰기 실패
      JSFunction.alertLocation(resp, "회원가입에 실패했습니다.",req.getContextPath() +"/membership/views/joinTeacher.jsp");
    }
  }
}

