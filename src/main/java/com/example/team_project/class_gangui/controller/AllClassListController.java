package com.example.team_project.class_gangui.controller;

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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AllClassListController", value = "/class/list.do")
@Slf4j
public class AllClassListController extends HttpServlet {

    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // session 값은 현재 없음...

        Map<String, Object> map = new HashMap<>();

        // 현재 등록되어 있는 강의 총 개수 가져오기
        int totalUploadedClassesCount = classDAO.getTotalUploadedClassesCount();
        log.info("현재 등록되어 있는 총 강의 개수 = {} 개", totalUploadedClassesCount);

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
        criteria.setAmount(12);
        map.put("pageNum", (criteria.getPageNum() - 1) * 12);

        // 현재 등록되어 있는 강의 12개 가져오기
        List<ClassDTO> classList = classDAO.getAllUploadedClassesList(map);

        map.remove("pageNum");
        PageMaker pageMaker = new PageMaker(criteria, totalUploadedClassesCount);
        request.setAttribute("pageMaker", pageMaker);
        request.setAttribute("classList", classList);
        request.getRequestDispatcher("/class_gangui/views/allClassList.jsp").forward(request, response);
    }
}
