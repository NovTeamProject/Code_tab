// 작성자 : 차소영

package com.example.team_project.student.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/student/myClass/list.do")
public class StudentMyClassController extends HttpServlet {
    // 학생이 수강신청한 강의들의 전체 리스트 목록

    private static final long serialVersionUID = 1L;

    private ClassDAO classDAO = new ClassDAO();
    private static final int PAGE_SIZE = 4; // 한 페이지에 보여줄 강의 수

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getSession().setAttribute("studentIdx", 1);

        // 세션에서 학생 idx를 받아옴
        int studentIdx = (Integer) req.getSession().getAttribute("studentIdx");

        // 페이지 번호를 파라미터에서 받아옴
        int pageNo = 1;
        if(req.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(req.getParameter("pageNo"));
        }

        // 학생이 등록한 강의 목록을 가져옴
        Map<String, Integer> map = new HashMap<>();
        map.put("studentIdx", studentIdx);
        map.put("startIdx", (pageNo - 1) * PAGE_SIZE);
        map.put("pageSize", PAGE_SIZE);

        List<Map<String, Object>> registeredClassList = classDAO.getRegisteredClasses(studentIdx);
        // ClassDAO 객체를 사용하여 학생이 등록한 강의 목록을 가져오는 코드
        // registeredClassList 변수에는 강의 정보가 담긴 Map의 리스트가 저장

        // 총 페이지 수를 계산
        int totalCount = classDAO.getStudentRegisteredClassCount(studentIdx);
        // ClassDAO 객체를 사용하여 학생이 등록한 강의의 전체 개수를 가져오는 코드
        // totalCount 변수에는 강의의 총 개수가 저장

        int totalPage = (totalCount % PAGE_SIZE == 0) ? totalCount / PAGE_SIZE : totalCount / PAGE_SIZE + 1;
        // 총 페이지 수를 계산하는 코드
        // PAGE_SIZE를 한 페이지에 보여줄 강의 수로 설정하고, 강의의 총 개수에 따라 총 페이지 수를 계산
        // totalCount가 PAGE_SIZE로 나누어 떨어지면 totalCount / PAGE_SIZE 값이 총 페이지 수가 되고,
        // 그렇지 않은 경우에는 totalCount / PAGE_SIZE + 1 값이 총 페이지 수가 됨

        // JSP 페이지에서 사용하기 위해 registeredClassList를 request attribute에 저장하는 코드
        req.setAttribute("ClassList", registeredClassList);


        req.setAttribute("totalPage", totalPage);
        req.setAttribute("pageNo", pageNo);

        // forward를 사용하여 request와 response 객체를 /myClass/views/myClassList.jsp로 전달하는 코드
        // 이 코드를 통해 나의 강의실 페이지로 이동
        req.getRequestDispatcher("/myClass/views/myClassList.jsp").forward(req, resp);
    }
}