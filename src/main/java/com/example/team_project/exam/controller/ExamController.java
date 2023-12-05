package com.example.team_project.exam.controller;


import com.example.team_project.exam.dao.ExamDAO;
import com.example.team_project.utils.JSFunction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exam.do")
public class ExamController  extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    ExamDAO eDao = new ExamDAO();
    String check = req.getParameter("examId");
    int examId;

    if ("정보처리기사".equals(check)) {
      examId = 1;
    } else {
      examId = 2;
    }
    int result = 0;
    int temp = 0;

    for (int i = 1; i <= 20; i++) {
      String answerValue = req.getParameter("answer" + i);
    // 기본값 설정

      if (answerValue != null && !answerValue.isEmpty() && answerValue.matches("[1-4]")) {
         temp = eDao.ExamAnswer(examId, i, Integer.parseInt(answerValue));
      }
      result += temp;
    }

    resp.setCharacterEncoding("UTF-8");
    req.setAttribute("score",result);
    req.setAttribute("examname",check);
    System.out.println("******************************"+result);

    RequestDispatcher dispatcher = req.getRequestDispatcher("/exam/views/exam.jsp");
    dispatcher.forward(req, resp);
  }
}
