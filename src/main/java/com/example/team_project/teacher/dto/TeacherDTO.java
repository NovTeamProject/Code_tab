package com.example.team_project.teacher.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TeacherDTO {

    private int teacherIdx; // primary key
    private String teacherId; // like naver id
    private String teacherPassword; // password
    private String teacherName; // real name
    private LocalDateTime teacherJoinDate; // register date
    private int teacherMoney; // income
}
