package com.example.team_project.ranking.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.class_gangui.dto.ClassDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ranking.do")
public class RankingController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    ClassDAO classDAO = new ClassDAO();

    List<String> rankingClass = classDAO.rankingClass();
    System.out.println("test"+rankingClass);

    req.setAttribute("rankingClass", rankingClass);

    RequestDispatcher dispatcher = req.getRequestDispatcher("/ranking/views/ranking.jsp");

    dispatcher.forward(req, resp);
  }
}
