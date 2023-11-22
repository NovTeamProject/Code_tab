package com.example.team_project.teacher.mapper;

import com.example.team_project.teacher.dto.ClassDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassMapper {
    int insertNewClass(ClassDTO dto);
}
