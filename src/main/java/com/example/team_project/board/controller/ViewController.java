package com.example.team_project.board.controller;

import com.example.team_project.board.dao.BoardDAO;
import com.example.team_project.board.dto.BoardDTO;
import com.example.team_project.comment.dao.CommentDAO;
import com.example.team_project.comment.dto.CommentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/board/view.do")
public class ViewController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 게시물 불러오기
        BoardDAO dao = new BoardDAO();
        String sboardIdx = request.getParameter("boardIdx");
        String classIdx = request.getParameter("classIdx");
        dao.updateVisitCount(sboardIdx);  // 조회수 1 증가
        BoardDTO dto = dao.selectView(sboardIdx);

        // 줄바꿈 처리
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));

        request.setAttribute("classIdx", classIdx);
        request.setAttribute("boardIdx", sboardIdx);

        // 게시물 댓글 불러오기
        CommentDAO commentDAO = new CommentDAO();
        int boardIdx = Integer.parseInt(request.getParameter("boardIdx"));

        List<CommentDTO> comments = commentDAO.selectCommentsByBoardIdx(boardIdx);


        // 댓글 리스트 줄바꿈 처리 - 필요에 따라 각 댓글의 내용에 대한 처리가 필요할 수 있습니다.
        for (CommentDTO comment : comments) {
            comment.setContent(comment.getContent().replaceAll("\r\n", "<br/>"));
        }

        request.setAttribute("boardIdx", boardIdx);
        // 불러온 댓글 리스트를 저장하고 뷰로 포워드
        request.setAttribute("comments", comments);
        // 게시물(dto) 저장 후 뷰로 포워드
        request.setAttribute("dto", dto);
        request.getRequestDispatcher("/board/View.jsp").forward(request, response);
    }
}
