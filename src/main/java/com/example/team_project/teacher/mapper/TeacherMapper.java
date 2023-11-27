package com.example.team_project.teacher.mapper;

import com.example.team_project.teacher.dto.TeacherDTO;

import java.util.List;
import java.util.Map;
public interface TeacherMapper {
    // 변재혁님 여기 아래부터 작성 시작
    List<TeacherDTO> getAllTeacher();


    // 남원우님 여기 아래부터 작성 시작

     int joinTeacher (TeacherDTO dto);
     List<TeacherDTO> loginTeacher(Map<String, String> map);
    // 차소영님 여기 아래부터 작성 시작


    // 유지호님 여기 아래부터 작성 시작

}
