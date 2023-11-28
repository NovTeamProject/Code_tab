package com.example.team_project.board.controller;

import com.example.team_project.board.dao.BoardDAO;
import com.example.team_project.board.dto.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/view.do")
public class ViewController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 게시물 불러오기
        BoardDAO dao = new BoardDAO();
        String boardIdx = req.getParameter("boardIdx");
        String classIdx = req.getParameter("classIdx");
        dao.updateVisitCount(boardIdx);  // 조회수 1 증가
        BoardDTO dto = dao.selectView(boardIdx);

        // 줄바꿈 처리
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));

        req.setAttribute("classIdx", classIdx);
        req.setAttribute("boardIdx", boardIdx);

        // 게시물(dto) 저장 후 뷰로 포워드
        req.setAttribute("dto", dto);
        req.getRequestDispatcher("/board/View.jsp").forward(req, resp);
    }
}
