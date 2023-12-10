//        Created by IntelliJ IDEA.
//        작성자: 차소영
//        최종 수정일 : 2023-12-11

package com.example.team_project.student.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.class_gangui.dto.ClassDTO;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static com.example.team_project.utils.JSFunction.alertLocation;

@WebServlet(name= "StudentClassDetailController", value = "/student/myClass/detail.do")
@Slf4j
public class StudentClassDetailController extends HttpServlet {

    // 학생이 수강신청한 한 개의 강의의 상세 페이지(뷰)

    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션 객체 생성
        HttpSession session = req.getSession();


//        // 세션에서 학생 인덱스 가져오기
//        int studentIdx = (Integer) session.getAttribute("student_idx");


        // 테스트용으로, 임의의 값 1을 넣어준다
        //session.setAttribute("student_idx", 1);


        // 세션에서 "studentIdx"라는 이름의 속성 값을 가져옴
        // 이 값은 로그인한 학생의 ID
        Object studentIdxObj = session.getAttribute("studentIdx");

        // 학생 인덱스 유효성 검사
        // 학생 ID가 세션에 없으면 로그인이 필요하다는 메시지를 출력하고 로그인 페이지로 리다이렉트함
        if (studentIdxObj == null) {
            alertLocation(resp, "로그인이 필요한 서비스입니다.", req.getContextPath() + "/student/login.do");
            return;
        }

        // 학생 ID를 정수로 변환
        int studentIdx = (Integer) studentIdxObj;

        // 요청 파라미터에서 "classIdx"라는 이름의 값을 가져옴
        // 이 값은 상세 정보를 보려는 클래스의 ID
        String classIdx = req.getParameter("classIdx");
        int classIdxInt = -1;

        // 클래스 ID가 유효한지 확인. 유효하지 않으면 에러 메시지를 출력하고 클래스 목록 페이지로 리다이렉트
        if (classIdx == null || classIdx.isEmpty()) {
            alertLocation(resp, "올바르지 않은 강의 번호입니다", req.getContextPath() + "/class/list.do");
            return;
        } else {
            try {
                classIdxInt = Integer.parseInt(classIdx.trim());
            } catch (Exception e) {
                alertLocation(resp, "올바르지 않은 강의 번호입니다", req.getContextPath() + "/class/list.do");
                return;
            }
        }


        // 클래스 ID와 학생 ID를 담은 맵을 생성
        Map<String, Object> params = new HashMap<>();
        params.put("classIdx", classIdxInt); // 'classIdx' 키를 사용
        params.put("studentIdx", studentIdx); // 'studentIdx' 키를 사용



        // 학생이 신청한 강의인지 확인
        int validCount = classDAO.checkIfSpecificStudentIdxRegisteredSpecificClassIdx(classIdxInt, studentIdx);
        if (validCount != 1) {
            alertLocation(resp, "수강 신청한 강의만 상세 조회할 수 있습니다", req.getContextPath() + "/student/myClass/list.do");
            return;
        }

        // 강의 상세 정보 가져오기
        ClassDTO classDTO = classDAO.getOneClassInformationWithRelatedLessons(classIdxInt);
        // 강의 정보를 요청 객체에 속성으로 추가
        req.setAttribute("classDTO", classDTO);
        // 강의 상세 정보 페이지로 포워딩
        req.getRequestDispatcher("/student/views/studentClassDetail.jsp")
                .forward(req, resp);
    }


    // 메시지를 출력하고 특정 페이지로 리다이렉트하는 메서드
    private void alertLocation(HttpServletResponse resp, String msg, String url) {
        try {

            // 응답 컨텐츠 타입을 HTML로 설정
            resp.setContentType("text/html;charset=UTF-8");

            // 응답 객체로부터 PrintWriter를 가져옴
            // 이를 통해 클라이언트에게 HTML을 출력
            PrintWriter writer = resp.getWriter();

            // 메시지를 출력하고 지정한 URL로 리다이렉트하는 자바스크립트 코드를 생성
            String script = "<script>"
                    + "    alert('" + msg + "');"
                    + "    location.href='" + url + "';"
                    + "</script>";
            writer.print(script);
            writer.flush();
            writer.close();
        } catch (Exception e) {

        }
    }
}