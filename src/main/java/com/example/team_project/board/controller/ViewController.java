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
        BoardDAO dao = new BoardDAO(); // 게시물 불러오기
        String sboardIdx = request.getParameter("boardIdx"); // HTML로부터 boardIdx 값을 받아와서 저장, boardList 컬럼에 저장
        String classIdx = request.getParameter("classIdx");  // classIdx 값을 쿼리스트링으로 부터 받아와서 저장
        dao.updateVisitCount(sboardIdx);  // 조회수 1 증가
        BoardDTO dto = dao.selectView(sboardIdx); // dao의 selectView 쿼리 사용, 해당 게시물의 값을 가져옴

        // 줄바꿈 처리
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));

        request.setAttribute("classIdx", classIdx); // classIdx 값을 request 영역에 저장
        request.setAttribute("boardIdx", sboardIdx); // boardIdx 값을 request 영역에 저장

        // 게시물 댓글 불러오기
        CommentDAO commentDAO = new CommentDAO();  // 답글 사용
        int boardIdx = Integer.parseInt(request.getParameter("boardIdx")); // HTML로부터 받아온 boardIdx값을 Int 값으로 저장

        List<CommentDTO> comments = commentDAO.selectCommentsByBoardIdx(boardIdx); // List에 답글 저장


        // 댓글 리스트 줄바꿈 처리 - 필요에 따라 각 댓글의 내용에 대한 처리가 필요할 수 있습니다.
        for (CommentDTO comment : comments) {
            comment.setContent(comment.getContent().replaceAll("\r\n", "<br/>"));
        }

        request.setAttribute("boardIdx", boardIdx);  // boardIdx 값을 request 영역에 저장
        request.setAttribute("comments", comments);  // comment 값을 request 영역에 저장
        request.setAttribute("dto", dto); // 게시물을 보여주기 위해서 dto을 request 영역에 저장
        request.getRequestDispatcher("/board/View.jsp").forward(request, response); // View.jsp로 포워드
    }
}
