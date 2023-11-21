package com.example.team_project.teacher.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TeacherDTO {
    private int teacherIdx; // primary key
    private String teacherId; // like naver id
    private String teacherPassword; // password
    private String teacherName; // real name
    private LocalDateTime teacherJoinDate; // register date
    private int teacherMoney; // income
}
