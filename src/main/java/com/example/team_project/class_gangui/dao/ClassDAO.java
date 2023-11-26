package com.example.team_project.class_gangui.dao;

import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import com.example.team_project.class_gangui.dto.ClassDTO;
import com.example.team_project.class_gangui.mapper.ClassMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ClassDAO {

    // 변재혁님 여기 아래부터 시작
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

    // 남원우님 여기 아래부터 작성 시작



    // 차소영님 여기 아래부터 작성 시작

    public boolean registerClass(int classIdx, int studentIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("classIdx", classIdx);
        map.put("studentIdx", studentIdx);
        int result = classMapper.registerClass(map);
        sqlSession.commit();
        sqlSession.close();
        return result > 0;
    }

    public boolean cancelClass(int classIdx, int studentIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("classIdx", classIdx);
        map.put("studentIdx", studentIdx);
        int result = classMapper.cancelClass(map);
        sqlSession.commit();
        sqlSession.close();
        return result > 0;
    }

    public List<ClassDTO> getRegisteredClasses(int studentIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<ClassDTO> classList = classMapper.getRegisteredClasses(studentIdx);
        sqlSession.close();
        return classList;
    }

    // 유지호님 여기 아래부터 작성 시작
    
}
