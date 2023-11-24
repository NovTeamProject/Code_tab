package com.example.team_project.teacher.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.class_gangui.dto.ClassDTO;
import com.example.team_project.teacher.paging.Criteria;
import com.example.team_project.teacher.paging.PageMaker;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TeacherClassListController", value = "/teacher/class/list.do")
@Slf4j
public class TeacherClassListController extends HttpServlet {

    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 테스트를 위해 임시로 teacher_idx의 값을 1로 설정
        HttpSession session = request.getSession();
        session.setAttribute("teacher_idx", 1);
        // -------------------------------------------
        int teacherIdx = (Integer) session.getAttribute("teacher_idx");

        Map<String, Object> map = new HashMap<>();
        // 현재 선생님이 등록한 강의 총 개수 가져오기
        int totalClassCount = classDAO.getAllUploadedClassesCountFilteredByTeacherIdx(teacherIdx);
        log.info("선생님 번호: {}번, 등록한 강의 개수: {}", teacherIdx, totalClassCount);

        // 페이징
        Criteria criteria = new Criteria();
        String pageNum = request.getParameter("pageNum");
        int pageNumInt = 1;
        if (pageNum != null && pageNum.trim().length() != 0) {
            try {
                pageNumInt = Integer.parseInt(pageNum.trim());
            } catch (Exception e) {
                log.info("숫자로 변환할 수 없는 pageNum. default 값 1로 설정 됨");
            }
        }
        criteria.setPageNum(pageNumInt);
        map.put("pageNum", (criteria.getPageNum() - 1) * 10);
        map.put("teacherIdx", teacherIdx);

        // 현재 로그인한 선생님이 등록한 강의 리스트 목록 갖고오기
        List<ClassDTO> classList = classDAO.getAllUploadedClassesListFilteredByTeacherIdx(map);

        // view로 forward (전달)
        map.remove("pageNum");
        PageMaker pageMaker = new PageMaker(criteria, totalClassCount);
        request.setAttribute("pageMaker", pageMaker);
        request.setAttribute("classList", classList);
        request.getRequestDispatcher("/teacher/views/teacherClassList.jsp").forward(request, response);
    }
}
