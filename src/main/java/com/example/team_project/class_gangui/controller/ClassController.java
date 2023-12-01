package com.example.team_project.class_gangui.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.class_gangui.dto.ClassDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ClassController")
// 서블릿을 정의하는 어노테이션
// 클라이언트가 "/ClassController" URL로 요청을 보내면 이 서블릿이 처리한다.

public class ClassController extends HttpServlet {
    // HttpServlet은 웹 서버에서 HTTP 프로토콜을 지원하는 서블릿을 정의하기 위한 클래스

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doPost 메소드는 클라이언트가 POST 방식으로 요청을 보내면 호출된다.

        String action = request.getParameter("action");
        // HttpServletRequest의 getParameter 메서드를 사용해 "action" 파라미터 값을 가져옴.

        ClassDAO classDAO = new ClassDAO();
        // ClassDAO 객체 생성. 객체를 통해 데이터베이스 연산을 수행

        if ("register".equals(action)) {
            // "action" 파라미터 값에 따라 다른 동작을 수행함.
            // "register"인 경우, 클래스를 등록하는 동작을 수행함.

            int classIdx = Integer.parseInt(request.getParameter("classIdx"));
            int studentIdx = Integer.parseInt(request.getParameter("studentIdx"));
            // HttpServletRequest의 getParameter 메소드를 사용해 "classIdx"와 "studentIdx" 파라미터 값을 가져온다.
            // 이 값들은 String 타입이므로 Integer.parseInt 메소드를 사용해 int 타입으로 변환

            boolean result = classDAO.registerClass(classIdx, studentIdx);
            // ClassDAO의 registerClass 메소드를 호출해 클래스를 등록함.
            // 이 메소드의 반환 값은 boolean 타입이므로, 등록이 성공하면 true, 실패하면 false

            request.setAttribute("result", result ? "Registration Successful" : "Registration Failed");
            // HttpServletRequest의 setAttribute 메소드를 사용해 "result"라는 이름으로 결과 메시지를 저장
            // 이 메시지는 JSP 페이지에서 사용된다.

        } else if ("cancel".equals(action)) {
            // "action" 파라미터 값이 "cancel"인 경우, 클래스를 취소하는 동작을 수행함.

            int classIdx = Integer.parseInt(request.getParameter("classIdx"));
            int studentIdx = Integer.parseInt(request.getParameter("studentIdx"));
            boolean result = classDAO.cancelClass(classIdx, studentIdx);
            request.setAttribute("result", result ? "Cancellation Successful" : "Cancellation Failed");

        } else if ("view".equals(action)) {
            // "action" 파라미터 값이 "view"인 경우, 등록된 클래스를 조회하는 동작을 수행함.

            int studentIdx = Integer.parseInt(request.getParameter("studentIdx"));
            List<ClassDTO> classList = classDAO.getRegisteredClassesList(studentIdx);
            // ClassDAO의 getRegisteredClasses 메소드를 호출해 등록된 클래스 목록을 가져옴.
            // 이 메소드의 반환 값은 ClassDTO 객체를 원소로 가지는 List이다.

            request.setAttribute("classList", classList);
        }
        // HttpServletRequest의 setAttribute 메소드를 사용해 "classList"라는 이름으로 클래스 목록을 저장
        // 이 클래스 목록은 JSP 페이지에서 사용된다.

        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        // RequestDispatcher를 사용해 요청을 JSP 페이지로 전달함.

        dispatcher.forward(request, response);
    }
}
