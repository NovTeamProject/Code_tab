package com.example.team_project.class_gangui.mapper;

import com.example.team_project.class_gangui.dto.ClassDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClassMapper {
    // 변재혁님 여기 아래부터 작성 시작
    int insertNewClass(ClassDTO dto);

    int getAllUploadedClassesCountFilteredByTeacherIdx(int teacherIdx);

    List<ClassDTO> getAllUploadedClassListFilteredByTeacherIdxWithPaging(Map<String, Object> map);


    ClassDTO getOneClassInformationWithRelatedLessons(int classIdx);

    int checkIfSpecificTeacherIdxUploadedSpecificClassIdx(@Param("classIdx") int classIdxInt,
                                                          @Param("teacherIdx") int teacherIdx);

    // 남원우님 여기 아래부터 작성 시작


    // 차소영님 여기 아래부터 작성 시작
    int registerClass(Map<String, Integer> map);
    int cancelClass(Map<String, Integer> map);
    List<ClassDTO> getRegisteredClasses(int studentIdx);

    // 유지호님 여기 아래부터 작성 시작
    String getClassNameByClassIdx(String classIdx);

}
