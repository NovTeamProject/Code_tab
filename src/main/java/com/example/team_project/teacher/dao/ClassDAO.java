package com.example.team_project.teacher.dao;

import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import com.example.team_project.teacher.dto.ClassDTO;
import com.example.team_project.teacher.mapper.ClassMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class ClassDAO {

    public boolean insertNewClass(ClassDTO classDTO) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        int result = classMapper.insertNewClass(classDTO);
        sqlSession.close();
        if (result == 1) {
            log.info("새로운 클래스 데이터베이스 저장 성공 - 클래스 PK: {}", classDTO.getClassIdx());
            return true;
        } else {
            log.info("새로운 클래스 데이터베이스 저장 실패");
            return false;
        }
    }
}
