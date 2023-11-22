package com.example.team_project.teacher.mapper;

import com.example.team_project.teacher.dto.LessonDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LessonMapper {
    int insertNewLesson(LessonDTO dto);
}
