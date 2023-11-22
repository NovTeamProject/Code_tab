package com.example.team_project.teacher.dao;

import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import com.example.team_project.teacher.dto.LessonDTO;
import com.example.team_project.teacher.mapper.LessonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class LessonDAO {

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
}
