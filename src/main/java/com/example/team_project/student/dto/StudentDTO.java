package com.example.team_project.student.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StudentDTO {
    private int studentIdx;
    private String studentId;
    private String studentPassword;
    private String studentName;
    private LocalDateTime studentJoinDate;
}
