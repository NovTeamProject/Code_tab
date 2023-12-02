package com.example.team_project.filter;

import com.example.team_project.utils.JSFunction;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/student/*")
public class StudentLoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("학생이 로그인 했는지 확인하는 필터 작동!");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("studentIdx") == null) {
            JSFunction.alertLocation((HttpServletResponse) servletResponse, "먼저 학생으로 로그인해주세요!", httpServletRequest.getContextPath() + "/membership/views/loginStudent.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
