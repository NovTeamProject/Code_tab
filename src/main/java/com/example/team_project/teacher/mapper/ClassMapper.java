package com.example.team_project.teacher.mapper;

import com.example.team_project.teacher.dto.ClassDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClassMapper {
    int insertNewClass(ClassDTO dto);

    int getAllUploadedClassesCountFilteredByTeacherIdx(int teacherIdx);

    List<ClassDTO> getAllUploadedClassListFilteredByTeacherIdxWithPaging(Map<String, Object> map);
}
