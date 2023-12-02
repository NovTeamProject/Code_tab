package com.example.team_project.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter("/teacher/*")
@Slf4j
public class TeacherLoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("TeacherLoginCheckFilter 작동");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpServletRequest.getSession();
        if (httpSession.getAttribute("teacherIdx") != null) {
            if (httpSession.getAttribute("personType") != null) {
                int personType = (Integer) httpSession.getAttribute("personType");
                if (personType == 0) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    log.info("선생님으로 로그인했는지 확인하는 필터 통과!");
                } else {
                    // http://localhost:8090/Team_Project_war_exploded/membership/views/loginTeacher.jsp
                    alertLocation((HttpServletResponse) servletResponse, "선생님으로 먼저 로그인 해주세요",
                            httpServletRequest.getContextPath() + "/membership/views/loginTeacher.jsp");
                }
            }
        } else {
            alertLocation((HttpServletResponse) servletResponse, "선생님으로 먼저 로그인 해주세요",
                    httpServletRequest.getContextPath() + "/membership/views/loginTeacher.jsp");
        }
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
