package com.example.team_project.teacher.dao;

import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import com.example.team_project.teacher.dto.ClassDTO;
import com.example.team_project.teacher.mapper.ClassMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class ClassDAO {

    public boolean insertNewClass(ClassDTO classDTO) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        int result = classMapper.insertNewClass(classDTO);
        if (result > 0) {
            log.info("새로운 강의 저장 성공 - 강의 PK: {}", classDTO.getClassIdx());
            sqlSession.commit();
            sqlSession.close();
            return true;
        } else {
            log.info("새로운 강의 저장 실패");
            sqlSession.close();
            return false;
        }
    }

    public int getAllUploadedClassesCountFilteredByTeacherIdx(int teacherIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        int uploadedCount = classMapper.getAllUploadedClassesCountFilteredByTeacherIdx(teacherIdx);
        sqlSession.close();
        return uploadedCount;
    }

    public List<ClassDTO> getAllUploadedClassesListFilteredByTeacherIdx(Map<String, Object> map) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<ClassDTO> classList = classMapper.getAllUploadedClassListFilteredByTeacherIdxWithPaging(map);
        sqlSession.close();
        return classList;
    }
}
