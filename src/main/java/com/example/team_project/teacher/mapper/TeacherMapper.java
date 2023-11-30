package com.example.team_project.teacher.mapper;

import com.example.team_project.student.dto.StudentDTO;
import com.example.team_project.teacher.dto.TeacherDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {
    // 변재혁님 여기 아래부터 작성 시작
    List<TeacherDTO> getAllTeacher();


    // 남원우님 여기 아래부터 작성 시작

     int joinTeacher (TeacherDTO dto);
     int loginTeacher(Map <String, String> map);

     TeacherDTO idCheck(String teacherId);
     TeacherDTO infoTeacher(String teacherId);
    // 차소영님 여기 아래부터 작성 시작


    // 유지호님 여기 아래부터 작성 시작

}
