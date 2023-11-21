package com.example.team_project.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/*")
@Slf4j
public class UTF8EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("UTF8EncodingFilter 적용");
        // jsp로 forward할 때 필터 적용 안 됨
        // .jsp를 바로 호출 시에는 적용 됨
        servletRequest.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
