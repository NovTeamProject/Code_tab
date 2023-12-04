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
        int studentIdx = (Integer)req.getSession().getAttribute("studentIdx");
        int classIdx = Integer.parseInt(req.getParameter("classIdx"));

        boolean successfullyDeleted = classDAO.deleteClass(classIdx, studentIdx);

        if (successfullyDeleted) {
            resp.getWriter().write("success");
        } else {
            resp.getWriter().write("failure");
        }
    }
}



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
