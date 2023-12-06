package com.example.team_project.lesson_sueop.mapper;

import com.example.team_project.lesson_sueop.dto.LessonDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LessonMapper {
    // 변재혁님 여기 아래부터 작성 시작
    int insertNewLesson(LessonDTO dto);
    int updateLessonWithNewVideo(LessonDTO dto);
    int updateLessonWithoutNewVideo(LessonDTO dto);
    int removeUnnecessaryLessons(Map<String, Object> map);

    // 남원우님 여기 아래부터 작성 시작



    // 차소영님 여기 아래부터 작성 시작



    // 유지호님 여기 아래부터 작성 시작

}
