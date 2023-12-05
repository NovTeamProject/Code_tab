package com.example.team_project.lesson_sueop.dao;

import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import com.example.team_project.lesson_sueop.dto.LessonDTO;
import com.example.team_project.lesson_sueop.mapper.LessonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class LessonDAO {

    // 변재혁님 여기 아래부터 작성 시작
    public boolean insertNewLesson(LessonDTO lessonDTO) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);
        int result = lessonMapper.insertNewLesson(lessonDTO);
        if (result > 0) {
            log.info("새로운 수업 저장 성공 - 수업 PK: {}", lessonDTO.getClassIdx());
            sqlSession.commit();
            sqlSession.close();
            return true;
        } else {
            log.info("새로운 수업 저장 실패");
            sqlSession.close();
            return false;
        }
    }

    public boolean updateLessonWithNewVideo(LessonDTO lessonDTO) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);
        int result = lessonMapper.updateLessonWithNewVideo(lessonDTO);
        if (result == 1) {
            log.info("수업 수정 성공.");
            sqlSession.commit();
            sqlSession.close();
            return true;
        } else {
            log.info("수업 수정 실패!");
            sqlSession.close();
            return false;
        }
    }

    public boolean updateLessonWithoutNewVideo(LessonDTO lessonDTO) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);
        int result = lessonMapper.updateLessonWithoutNewVideo(lessonDTO);
        if (result == 1) {
            log.info("수업 수정 성공.");
            sqlSession.commit();
            sqlSession.close();
            return true;
        } else {
            log.info("수업 수정 실패!");
            sqlSession.close();
            return false;
        }
    }

    public int removeUnnecessaryLessons(int classIdx, List<Integer> list, int expectedResult) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("classIdx", classIdx);
        map.put("list", list);
        int result = lessonMapper.removeUnnecessaryLessons(map);
        if (result == expectedResult) {
            System.out.println("필요 없는 강의 삭제 완료.");
            sqlSession.commit();
        } else {
            System.out.println("필요 없는 강의 삭제 실패");
        }
        sqlSession.close();
        return result;
    }

    // 남원우님 여기 아래부터 작성 시작


    // 차소영님 여기 아래부터 작성 시작


    // 유지호님 여기 아래부터 작성 시작

}
