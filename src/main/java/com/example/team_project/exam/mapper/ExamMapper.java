package com.example.team_project.exam.mapper;

import org.apache.ibatis.annotations.Param;

public interface ExamMapper {
  int answerTable(@Param("examId") int examId,
                  @Param("examNum")int examNum,
                  @Param("examAnswer") int examAnswer);
}
