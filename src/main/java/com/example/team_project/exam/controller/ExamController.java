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

    ExamDAO eDao = new ExamDAO();                           // ExamDAO 객체 생성
    String check = req.getParameter("examId");        // examId의 파라미터값을 가져옴
    int examId;                                             // int타입의 examId 객체 선언

    if ("정보처리기사".equals(check)) {                       // 시험의 종류가 '정보처리기사'인 경우
      examId = 1;                                           // examId에 1을 저장
    } else {
      examId = 2;                                           // examId에 2를 저장
    }
    int result = 0;
    int temp = 0;

    for (int i = 1; i <= 20; i++) {
      String answerValue = req.getParameter("answer" + i);     // 각 문제에 대해 answer 값을 가져옴

    // 유효성 테스트
      if (answerValue != null && !answerValue.isEmpty() && answerValue.matches("[1-4]")) { // 답안 값이 유효한 경우
         temp = eDao.ExamAnswer(examId, i, Integer.parseInt(answerValue));      // DAO를 통해 답안을 검증하고 점수를 가져옴
      }
      result += temp;           // 총 점수에 추가
    }

    resp.setCharacterEncoding("UTF-8");
    req.setAttribute("score",result);
    req.setAttribute("examname",check);
    System.out.println("****************************정답갯수"+result);

    RequestDispatcher dispatcher = req.getRequestDispatcher("/exam/views/exam.jsp");    // exam.jsp로 요청을 전달할 RequestDispatcher 객체 생성
    dispatcher.forward(req, resp);       //  dispatcher를 이용하여 req와 resp를 전달
  }
}
