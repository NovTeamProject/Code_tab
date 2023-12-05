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


@WebServlet("/board/write.do")
public class WriteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int classIdx = Integer.parseInt(req.getParameter("classIdx")); // 쿼리스트링으로부터 값을 받아옴
        req.setAttribute("classIdx", classIdx); // classIdx 값을 저장

        req.getRequestDispatcher("/board/Write.jsp").forward(req, resp); // Write.jsp로 전송
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int classIdx = Integer.parseInt(req.getParameter("classIdx"));  // classIdx를 쿼리스트링으로부터 받아와서 저장
        int studentIdx = (int) req.getSession().getAttribute("studentIdx"); // 세션으로부터 studentIdx를 받아와서 저장
        String studentName = (String) req.getSession().getAttribute("name");  // 세션으로부터 name을 받아와서 저장

        BoardDTO dto = new BoardDTO(); // BoardDTO 객체생성
        dto.setClassIdx(classIdx);   // classIdx 저장
        dto.setStudentIdx(studentIdx);  // studentIdx 저장
        dto.setStudentName(studentName);  // studentName 저장
        dto.setTitle(req.getParameter("title"));  // 쿼리스트링으로 부터 받은 title 값을 저장
        dto.setContent(req.getParameter("content")); // 쿼리스트링으로 부터 받은 content 값을 저장

        // DAO를 통해 DB에 게시 내용 저장
        BoardDAO dao = new BoardDAO();
        int result = dao.insertWrite(dto); // dao에 insertWrite 메서드에 dto 값을 통해 result 값 반환

        // 성공 or 실패?
        if (result == 1) {  // result가 1이면 글쓰기 성공
            resp.sendRedirect("../board/list.do?classIdx=" + classIdx);  // 성공후에 list.do로 이동. classIdx 값을 추가로 넘겨줌
        } else {  // 글쓰기 실패
            JSFunction.alertLocation(resp, "질문하기에 실패했습니다.",
                    "../board/write.do");  // 글쓰기에 실패할 경우
        }
    }
}
