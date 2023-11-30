package com.example.team_project.teacher.dao;

import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import com.example.team_project.student.dto.StudentDTO;
import com.example.team_project.student.mapper.StudentMapper;
import com.example.team_project.teacher.dto.TeacherDTO;
import com.example.team_project.teacher.mapper.TeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TeacherDAO {

  // 변재혁님 여기 아래부터 작성 시작


  // 남원우님 여기 아래부터 작성 시작

  // 회원가입(선생님)
  public int joinTeacher(TeacherDTO dto){
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
    int result = mapper.joinTeacher(dto);
    if (result == 1) {
      System.out.println("새로운 Teacher 저장 성공");
      sqlSession.commit();
    } else {
      System.out.println("새로운 Teacher 저장 실패");
    }
    sqlSession.close();
    return result;
  }
    // 로그인(선생님)
    public boolean loginTeacher(String teacherId, String teacherPassword) {
      Map<String, String> map = new HashMap<>();

      map.put("teacherId", teacherId);
      map.put("teacherPassword", teacherPassword);

      SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
      TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
      int result = mapper.loginTeacher(map);

      if (result == 1) {
        return true;
      } else {
        return false;
      }
    }
  // 아이디 중복 체크
  public TeacherDTO idCheck(String teacherId) {

    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
    TeacherDTO result = mapper.idCheck(teacherId);
    sqlSession.close();
    return result;

  }
  public TeacherDTO infoTeacher(String teacherId) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
    TeacherDTO result = mapper.infoTeacher(teacherId);
    sqlSession.close();
    return result;
  }
  // 차소영님 여기 아래부터 작성 시작
  

  // 유지호님 여기 아래부터 작성 시작


}
