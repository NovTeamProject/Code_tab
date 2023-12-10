//        Created by IntelliJ IDEA.
//        작성자: 차소영
//        최종 수정일 : 2023-12-11

package com.example.team_project.student.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.utils.JSFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/student/myClass/register.do")
public class StudentClassRegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentIdx = (Integer)req.getSession().getAttribute("studentIdx");
        int classIdx = Integer.parseInt(req.getParameter("classIdx"));

        // 학생이 이미 해당 클래스를 등록했는지 확인
        // 이미 등록했으면 true를, 그렇지 않으면 false를 반환
        boolean isAlreadyRegistered = classDAO.checkIfStudentRegisteredClass(classIdx, studentIdx);

        // 클래스를 등록하는 결과를 저장할 변수
        // 클래스 등록이 성공하면 true를, 실패하면 false를 저장
        boolean successfullyRegistered = false;

        // 학생이 이미 해당 클래스를 등록했는지 확인
        if (isAlreadyRegistered) {
            resp.getWriter().write("already_registered");
            return;
        } else {
            successfullyRegistered = classDAO.registerClass(classIdx, studentIdx);
        }

        // 클래스 등록이 성공했는지 확인
        if (successfullyRegistered) {
            resp.getWriter().write("success");
        } else {
            resp.getWriter().write("failure");
        }
    }
}