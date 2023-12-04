package com.example.team_project.teacher.controller;

import com.example.team_project.student.dao.StudentDAO;
import com.example.team_project.student.dto.StudentDTO;
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


@WebServlet("/teacheredit.do")
public class TeacherEditController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher(req.getContextPath() + "/membership/views/editTeacher.jsp").forward(req, resp);
  }
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 정보 수정 (선생님)

    String teacherPassword = req.getParameter("teacherPassword");
    String teacherName = req.getParameter("teacherName");
    String teacherAddress= null;

    if (req.getParameter("roadAddr")==null){
      teacherAddress = req.getParameter("roadAddr").concat("/").concat(req.getParameter("detailAddr"));
    }else {
      teacherAddress = req.getParameter("jibunAddr").concat("/").concat(req.getParameter("detailAddr"));
    }

    TeacherDTO tDto = new TeacherDTO();
    tDto.setTeacherId((String) req.getSession().getAttribute("teacherId"));
    tDto.setTeacherPassword(Encrypt.getEncrypt(teacherPassword));
    tDto.setTeacherName(teacherName);
    tDto.setTeacherAddress(teacherAddress);

    HttpSession session = req.getSession();
    session.setAttribute("loginMember", tDto);
    session.setAttribute("teacherIdx", tDto.getTeacherIdx());
    session.setAttribute("teacherId", tDto.getTeacherId());
    session.setAttribute("name", tDto.getTeacherName());
    session.setAttribute("personType",0); // 학생이면 2번, 선생 0번

    TeacherDAO tDao = new TeacherDAO();
    int result = tDao.editTeacher(tDto);

    // 성공 or 실패
    if (result == 1) {
      JSFunction.alertLocation(resp, "수정에 성공했습니다.",req.getContextPath() + "/index.jsp");
    } else { //실패
      JSFunction.alertLocation(resp, "수정에 실패했습니다.",req.getContextPath() +"/index.jsp");
    }
  }
}


