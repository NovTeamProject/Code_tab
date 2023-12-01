package com.example.team_project.board.controller;

import com.example.team_project.board.dao.BoardDAO;
import com.example.team_project.board.dto.BoardDTO;
import com.example.team_project.utils.JSFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/edit.do")
public class EditController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String boardIdx = req.getParameter("boardIdx");
        String classIdx = req.getParameter("classIdx");
        BoardDAO dao = new BoardDAO();
        BoardDTO dto = dao.selectView(boardIdx);
        req.setAttribute("dto", dto);
        req.setAttribute("classIdx", classIdx);
        req.getRequestDispatcher("/board/Edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // req.getParameter("idx");

        // 수정 내용을 매개변수에서 얻어옴
        String boardIdx = req.getParameter("boardIdx");
        int parsedBoardIdx = Integer.parseInt(boardIdx); // 문자열을 정수로 변환
        String classIdx = req.getParameter("classIdx");

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        // BoardDTO 객체 생성 후 값 설정
        BoardDTO dto = new BoardDTO();
        dto.setBoardIdx(parsedBoardIdx); // 정수 값으로 설정
        dto.setTitle(title);
        dto.setContent(content);

        // DB에 수정 내용 반영
        BoardDAO dao = new BoardDAO();
        int result = dao.updatePost(dto);

        // 성공 or 실패?
        if (result == 1) {  // 수정 성공
            resp.sendRedirect("../board/view.do?classIdx=" + classIdx + "&boardIdx=" + boardIdx);
        }
        else {  // 수정 실패
            JSFunction.alertLocation(resp, "다시 진행해주세요.",
                    req.getContextPath() + "/board/view.do?boardIdx=" + boardIdx);
        }
    }
}
