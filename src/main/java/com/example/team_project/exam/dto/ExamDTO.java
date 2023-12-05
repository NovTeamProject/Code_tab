package com.example.team_project.exam.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ExamDTO {
  int ExamId;
  int ExamNum;
  int ExamAnswer;
}
