package com.example.team_project.ranking.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/ranking.do")
public class RankingController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 명예의전당 입니다.
    ClassDAO classDAO = new ClassDAO();          // ClassDAO 객체 생성

    List<Map<String, Object>> rankingClass = classDAO.rankingClass();           // ClassDAO 의 rankingClass 메소드를 실행하여 값을 List 타입으로  rankingClass에 저장

    req.setAttribute("rankingClass", rankingClass);               // rankingClass를 req에 저장

    List<Map<String, Object>> uprankingClass = classDAO.uprankingClass();         // ClassDAO 의 uprankingClass 메소드를 실행하여 값을 List 타입으로  uprankingClass에 저장

    req.setAttribute("uprankingClass", uprankingClass);               //uprankingClass를 req에 저장

    RequestDispatcher dispatcher = req.getRequestDispatcher("/ranking/views/ranking.jsp");   // ranking.jsp로 요청을 전달할 RequestDispatcher 객체 생성

    dispatcher.forward(req, resp);     //  dispatcher를 이용하여 req와 resp를 전달
  }
}
