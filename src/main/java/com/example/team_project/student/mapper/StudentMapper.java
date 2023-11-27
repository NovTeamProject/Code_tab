package com.example.team_project.student.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;
@Mapper
public interface StudentMapper {
    // 변재혁님 여기 아래부터 작성 시작


    // 남원우님 여기 아래부터 작성 시작
    int joinStudent (StudentDTO dto);
    List<StudentDTO> loginStudent(Map <String, String> map);

    
    // 차소영님 여기 아래부터 작성 시작


    // 유지호님 여기 아래부터 작성 시작

}
