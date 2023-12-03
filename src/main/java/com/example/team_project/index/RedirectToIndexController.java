package com.example.team_project.index;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.class_gangui.dto.ClassDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/index.do")
public class RedirectToIndexController extends HttpServlet {
    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 인기 강의 Top3 가져오기
        List<ClassDTO> topThreeClassList = classDAO.getTop3ClassList();

        // 최근 등록된 강의 세 개 가져오기
        List<ClassDTO> recentClassList = classDAO.getRecentClassList();

        req.setAttribute("topThreeClassList", topThreeClassList);
        req.setAttribute("recentClassList", recentClassList);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
