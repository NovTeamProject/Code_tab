// 작성자 : 차소영

package com.example.team_project.student.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(value = "/student/myClass/delete.do")
public class StudentClassDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 세션에서 "studentIdx"라는 이름의 속성 값을 가져와서 정수로 변환
        // 이 값은 로그인한 학생의 ID
        int studentIdx = (Integer)req.getSession().getAttribute("studentIdx");

        // 요청 파라미터에서 "classIdx"라는 이름의 값을 가져와서 정수로 변환
        // 이 값은 삭제할 클래스의 ID
        int classIdx = Integer.parseInt(req.getParameter("classIdx"));

        // 클래스를 삭제합니다. 성공하면 true를, 실패하면 false를 반환
        boolean successfullyDeleted = classDAO.deleteClass(classIdx, studentIdx);

        // 클래스 삭제가 성공했는지 여부에 따라 응답
        if (successfullyDeleted) {
            resp.getWriter().write("success");
        } else {
            resp.getWriter().write("failure");
        }
    }
}




// 이전 코드

//@WebServlet(name = "StudentClassDeleteController", value = "/student/myClass/delete.do")
//public class StudentClassDeleteController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private ClassDAO classDAO = new ClassDAO();
//
//    // 학생이 수강신청한 강의를 삭제(취소)
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession httpSession = request.getSession();
//        int studentIdx = (Integer) httpSession.getAttribute("studentIdx");
//
//        ClassDAO classDAO = new ClassDAO();
//
//        int classIdx = Integer.parseInt(request.getParameter("classIdx"));
//
//        boolean result = classDAO.deleteClass(classIdx, studentIdx);
//        if (result) {
//            System.out.println("학생이 수강신청한 강의 삭제 완료");
//        } else {
//            System.out.println("학생이 수강신청한 강의 삭제 실패!");
//        }
//        resp.sendRedirect("/student/myClass/list.do");
//    }
//}
