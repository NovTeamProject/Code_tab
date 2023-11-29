package com.example.team_project.board.controller;

import com.example.team_project.board.dao.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/delete.do")
public class DeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String boardIdx = req.getParameter("boardIdx");
        String classIdx = req.getParameter("classIdx");

        BoardDAO dao = new BoardDAO();
        int result = dao.deletePost(boardIdx);

        if (result == 1) {
            resp.getWriter().write("success");
        } else {
            resp.getWriter().write("failure");
        }
    }
}