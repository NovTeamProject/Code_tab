package com.example.team_project.student.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/student/myClass/register.do")
public class StudentClassRegisterController extends HttpServlet {
    // 학생이 한 개의 강의를 수강신청

    private static final long serialVersionUID = 1L;
    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 테스트용, 로그인기능 되면, 이 아래 부분은 삭제
        // req.getSession().setAttribute("studentIdx", 1);

        //세션에서 학생 idx를 받아옴
        int studentIdx = (Integer)req.getSession().getAttribute("studentIdx");
        int classIdx = Integer.parseInt(req.getParameter("classIdx"));


        //학생이 이미 강의에 수강신청 했는지 확인
        boolean isAlreadyRegistered = classDAO.checkIfStudentRegisteredClass(classIdx, studentIdx);

        boolean successfullyRegistered = false;
        if (isAlreadyRegistered) {
            // 만약 이미 해당 강의를 수강신청 했다면, 전체 강의 리스트 화면으로 이동
            resp.sendRedirect("/class/list.do");

        } else {
            // 수강신청 하지 않았다면 DAO에 접근해서
            // 수업을 등록하는 메서드 호출
            successfullyRegistered = classDAO.registerClass(classIdx, studentIdx);
            //resp.sendRedirect("/student/class/register.do");
        }

        if (successfullyRegistered) {
            // 나의 강의실로 보내주고
            // resp.sendRedirect("/student/class/register.do");
        } else {
            // 전체 강의 리스트로 보내기
            System.out.println("학생 수강신청 실패");
        }
    }


    //DAO 접근해서 수강신청 했는지 체크해주는 로직 추가

        /* select count(*)
        from student_class
        where class_idx = #{classIdx} and student_idx = #{studentIdx}
        */

    //이 카운트 값이 0이 아니라면, 이미 해당 강의에 수강신청을 한 것이므로 더이상 진행할 필요가 없이 전체 강의 리스트 화면으로 이동

        /*insert
        into student_class
        * */
}


