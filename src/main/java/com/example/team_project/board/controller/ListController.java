package com.example.team_project.board.controller;

import com.example.team_project.board.dao.BoardDAO;
import com.example.team_project.board.dto.BoardDTO;
import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.student.dao.StudentDAO;
import com.example.team_project.utils.BoardPage;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ListController", value = "/board/list.do")
public class ListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //dao 생성
        BoardDAO dao = new BoardDAO();
        ClassDAO classDAO = new ClassDAO();
        StudentDAO studentDAO = new StudentDAO();

        // 뷰에 전달할 매개변수 저장용 맵 생성
        Map<String, Object> map = new HashMap<>();

        // 쿼리 스트링으로 강의 번호 받기
        String classIdx = request.getParameter("classIdx"); // 어떠한 강의에 대한 질문 게시판인지 알기 위해 clasIdx 값이 필요
        // 쿼리스트링에서 해당 값들을 가져옴
        String searchField = request.getParameter("searchField"); // null or content or title
        String searchWord = request.getParameter("searchWord"); // null or user input value
        if (searchWord != null && !searchWord.trim().equals("")) {
            map.put("searchField", searchField); // 검색 필드 값을 맵에 추가
            map.put("searchWord", searchWord);  // 검색어 값을 맵에 추가
        } // 처음 null 값이기 때문에 넘어감

        map.put("classIdx",classIdx); // classIdx -> 1 (key-value 쌍), classIdx를 맵에 저장

        if (request.getSession().getAttribute("studentIdx") != null) {  // 세션에 studentIdx가 null이 아니면 실행, null일 경우는 선생님 로그인
            int studentIdx = (Integer) request.getSession().getAttribute("studentIdx"); // 세션에 저장한 값을 불러와 저장
            map.put("studentIdx", studentIdx);       // 학생구분을 위한 studentIdx값을 map에 저장
            int check = studentDAO.checkStudentClass(map);
            // 학생 테이블에서 로그인한 학생이 해당 강의를 수강신청 했는지 확인하기 위해 사용
            // studentIdx와 classIdx 값이 존재하는 경우 1을 반환하며 질문이 가능하도록 함
            map.put("check", check); // map에 저장
        }

        String className = classDAO.getClassNameByClassIdx(classIdx);  // 강의 이름을 조회하기 위한 class 테이블에서 가져온 값
        map.put("className", className);  // 게시판 강의 이름을 보여주기 위해 사용

        if (request.getSession().getAttribute("personType") != null) {
            int personType = (int) request.getSession().getAttribute("personType"); // 세션의 personType
            map.put("personType", personType);
        }

        int totalCount = dao.selectCount(map); // total board count, map에 저장된 searchField, searchWord를 조건일때 사용하여 카운트

        /* 페이지 처리 start */
        ServletContext application = getServletContext();
        int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE")); // web.xml의 변수를 가져옴, 10
        int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));  // 10

        // 현재 페이지 확인
        int pageNum = 1;  // 기본값
        String pageTemp = request.getParameter("pageNum");  // 쿼리스트링 값을 가져옴
        if (pageTemp != null && !pageTemp.equals("")) {   // pageTemp가 null이 아니고 동일하지 않으면 실행
            pageNum = Integer.parseInt(pageTemp); // 요청받은 페이지로 수정
            // query string의 value 값은 String type인데, 그 String type의 값을 정수형(int)로 변환하기 위해서
            // Integer.parseInt(pageTemp); 메서드를 호출해서, String type을 int 타입으로 변경.
        }
        // 목록에 출력할 게시물 범위 계산
        int start = (pageNum - 1) * pageSize + 1;  // 첫 게시물 번호
        int end = pageNum * pageSize; // 마지막 게시물 번호
        map.put("start", start);
        map.put("end", end);
        /* 페이지 처리 end */

        List<BoardDTO> boardLists = dao.selectListPage(map);  // 게시물 목록 받기

        // 뷰에 전달할 매개변수 추가
        String pagingImg = BoardPage.pagingStr(totalCount, pageSize,
                blockPage, pageNum, request.getContextPath() + "/board/list.do", classIdx);  // 바로가기 영역 HTML 문자열
        map.put("pagingImg", pagingImg);
        map.put("totalCount", totalCount);
        map.put("pageSize", pageSize);
        map.put("pageNum", pageNum);

        // 전달할 데이터를 request 영역에 저장 후 List.jsp로 포워드
        request.setAttribute("boardLists", boardLists); // boardLists는 게시물 목록
        request.setAttribute("map", map); // 맵에 저장한 것을 맵이라는 값에 저장
        request.getRequestDispatcher("/board/List.jsp").forward(request, resp); // List.jsp로 전송
    }
}
