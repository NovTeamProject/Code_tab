package com.example.team_project.teacher.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TeacherLoginCheck {

    public static boolean checkIfTeacherLogined(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("personType") == null ||
                ((Integer) session.getAttribute("personType")) != 0 ||
                session.getAttribute("teacherIdx") == null) {
            return false;
        } else {
            return true;
        }
    }
}
