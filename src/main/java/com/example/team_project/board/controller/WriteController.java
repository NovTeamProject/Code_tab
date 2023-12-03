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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/board/write.do")
public class WriteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int classIdx = Integer.parseInt(req.getParameter("classIdx")); /*req.getParameter("classIdx");*/
        req.setAttribute("classIdx", classIdx); // classIdx 값을 저장

        req.getRequestDispatcher("/board/Write.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, Object> map1 = new HashMap<>();

        int classIdx = Integer.parseInt(req.getParameter("classIdx"));
        int studentIdx = (int) req.getSession().getAttribute("studentIdx");

        String studentName = (String) req.getSession().getAttribute("name");


        BoardDTO dto = new BoardDTO();
        dto.setClassIdx(classIdx);
        dto.setStudentIdx(studentIdx);
        dto.setStudentName(studentName);
        dto.setTitle(req.getParameter("title"));
        dto.setContent(req.getParameter("content"));

        // DAO를 통해 DB에 게시 내용 저장
        BoardDAO dao = new BoardDAO();
        int result = dao.insertWrite(dto);

        // 성공 or 실패?
        if (result == 1) {  // 글쓰기 성공
            /*resp.sendRedirect("../board/list.do");*/
            resp.sendRedirect("../board/list.do?classIdx=" + classIdx);
        } else {  // 글쓰기 실패
            JSFunction.alertLocation(resp, "질문하기에 실패했습니다.",
                    "../board/write.do");
        }
    }
}
