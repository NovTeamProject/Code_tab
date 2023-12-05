package com.example.team_project.comment.controller;

import com.example.team_project.comment.dao.CommentDAO;
import com.example.team_project.comment.dto.CommentDTO;
import com.example.team_project.utils.JSFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/board/comment.do")
public class CommentController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentDAO commentDAO = new CommentDAO();
        CommentDTO commentDTO  = new CommentDTO();
        int personType = (Integer) req.getSession().getAttribute("personType"); // personType을 세션에서 가져와서 저장

        if (personType == 0) {
            // personType가 0이면 선생님, 해당 값에 선생님의 정보를 세션에서 받아와서 저장
            commentDTO.setPersonType(0);
            commentDTO.setPersonIdx((Integer) req.getSession().getAttribute("teacherIdx"));
            commentDTO.setPersonName((String) req.getSession().getAttribute("name"));
        } else if (personType == 2) {
            // personType가 2이면 학생, 해당 값에 학생의 정보를 세션에서 받아와서 저장
            commentDTO.setPersonType(2);
           commentDTO.setPersonIdx((Integer) req.getSession().getAttribute("studentIdx"));
           commentDTO.setPersonName((String) req.getSession().getAttribute("name"));

        }
        int boardIdx = Integer.parseInt(req.getParameter("boardIdx"));
        int classIdx = Integer.parseInt(req.getParameter("classIdx"));

        commentDTO.setBoardIdx(boardIdx);
        commentDTO.setContent(req.getParameter("commentContent"));

        //List<CommentDTO> commentLists = commentDAO.selectCommentsByBoardIdx(boardIdx);

        // DAO를 통해 DB에 게시 내용 저장
        int result = commentDAO.insertComment(commentDTO);

        // 성공 or 실패?
        if (result == 1) {  // 글쓰기 성공
            /*resp.sendRedirect("../board/list.do");*/
            resp.sendRedirect(req.getContextPath() + "/board/view.do?classIdx=" + classIdx + "&boardIdx=" + boardIdx);
        } else {  // 글쓰기 실패
            JSFunction.alertLocation(resp, "질문하기에 실패했습니다.",
                    "../board/comment.do?boardIdx=" + boardIdx);
        }
    }
}