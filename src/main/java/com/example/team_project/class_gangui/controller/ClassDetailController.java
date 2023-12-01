package com.example.team_project.class_gangui.controller;

import com.example.team_project.class_gangui.dao.ClassDAO;
import com.example.team_project.class_gangui.dto.ClassDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ClassDetailController", value = "/class/detail.do")
public class ClassDetailController extends HttpServlet {

    private ClassDAO classDAO = new ClassDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String classIdx = request.getParameter("classIdx");
        int classIdxInt = -1;

        if (classIdx == null || classIdx.isEmpty()) {
            alertLocation(response, "올바르지 않은 강의 번호입니다", request.getContextPath() + "/class/list.do");
            return;
        } else {
            try {
                classIdxInt = Integer.parseInt(classIdx.trim());
            } catch (Exception e) {
                alertLocation(response, "올바르지 않은 강의 번호입니다", request.getContextPath() + "/class/list.do");
                return;
            }
        }

        ClassDTO classDTO = classDAO.getOneClassInformationWithRelatedLessons(classIdxInt);
        request.setAttribute("classDTO", classDTO);
        request.getRequestDispatcher("/class_gangui/views/classDetail.jsp")
                .forward(request, response);
    }

    private void alertLocation(HttpServletResponse resp, String msg, String url) {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            String script = "<script>"
                    + "    alert('" + msg + "');"
                    + "    location.href='" + url + "';"
                    + "</script>";
            writer.print(script);
            writer.flush();
            writer.close();
        }
        catch (Exception e) {}
    }
}
