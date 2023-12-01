<<<<<<< HEAD
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

@WebServlet("/upranking.do")
public class UpRankingController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    ClassDAO classDAO = new ClassDAO();

    List<String> rankingClass = classDAO.rankingClass();
    System.out.println(rankingClass);
    req.setAttribute("rankingClass", rankingClass);

    RequestDispatcher dispatcher = req.getRequestDispatcher("/ranking/views/ranking.jsp");

    dispatcher.forward(req, resp);
  }
}
=======
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

@WebServlet("/upranking.do")
public class UpRankingController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    ClassDAO classDAO = new ClassDAO();

    List<String> rankingClass = classDAO.rankingClass();
    System.out.println(rankingClass);
    req.setAttribute("rankingClass", rankingClass);

    RequestDispatcher dispatcher = req.getRequestDispatcher("/ranking/views/ranking.jsp");

    dispatcher.forward(req, resp);
  }
}
>>>>>>> 007d1a7bc15ff8105b02ce2eef816b13cfc353cd
