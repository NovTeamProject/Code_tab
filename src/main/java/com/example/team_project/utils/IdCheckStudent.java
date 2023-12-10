package com.example.team_project.utils;

import com.example.team_project.student.dao.StudentDAO;
import com.example.team_project.student.dto.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/IdCheckStudent.do")
public class IdCheckStudent extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // GET 요청이 들어왔을 때, joinTeacher.jsp 페이지로 포워딩
    req.getRequestDispatcher(req.getContextPath() + "/membership/views/joinStudent.jsp").forward(req, resp);
  }
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // POST 요청이 들어왔을 때, 선생님의 ID 중복 검사 진행
    String studentId = req.getParameter("studentId");   // 요청에서 'teacherId' 파라미터를 가져옴
    StudentDAO sDao = new StudentDAO();
    StudentDTO result = sDao.idCheck(studentId);    // DAO를 통해 ID 중복 검사 진행


    //  아이디 중복체크
    if (result == null ) {

      resp.setContentType("application/json");            // 응답의 Content-Type을 JSON으로 설정
      resp.getWriter().print("{\"result\": true}");       // JSON 형태의 응답을 작성하여 전송 (result: true)
    } else {

      resp.setContentType("application/json");              // 응답의 Content-Type을 JSON으로 설정
      resp.getWriter().print("{\"result\": false}");        // JSON 형태의 응답을 작성하여 전송 (result: true)
    }

  }
}