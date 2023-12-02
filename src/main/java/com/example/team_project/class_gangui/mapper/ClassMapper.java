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
    int getTotalUploadedClassesCount();
    List<ClassDTO> getAllUploadedClassesList(Map<String, Object> map);

    // 남원우님 여기 아래부터 작성 시작
    List<String> rankingClass();

    // 차소영님 여기 아래부터 작성 시작
    int registerClass(Map<String, Integer> map);
    int deleteClass(Map<String, Integer> map);
    List<Map<String, Object>> getRegisteredClasses(int studentIdx);
    int checkIfStudentRegisteredClass(Map<String, Integer> map);
    int getStudentRegisteredClassCount(int studentIdx);
    List<ClassDTO> getRegisteredClassesList(int studentIdx);
    int checkIfSpecificStudentIdxRegisteredSpecificClassIdx(Map<String, Object> params);

    // 유지호님 여기 아래부터 작성 시작
    String getClassNameByClassIdx(String classIdx);


}
