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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 게시물 불러오기
        BoardDAO dao = new BoardDAO();
        String boardIdx = request.getParameter("boardIdx");
        String classIdx = request.getParameter("classIdx");
        dao.updateVisitCount(boardIdx);  // 조회수 1 증가
        BoardDTO dto = dao.selectView(boardIdx);

        // 줄바꿈 처리
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));

        request.setAttribute("classIdx", classIdx);
        request.setAttribute("boardIdx", boardIdx);

        // 게시물(dto) 저장 후 뷰로 포워드
        request.setAttribute("dto", dto);
        request.getRequestDispatcher("/board/View.jsp").forward(request, response);
    }
}
