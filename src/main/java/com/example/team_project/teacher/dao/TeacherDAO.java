package com.example.team_project.teacher.dao;

import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import com.example.team_project.teacher.dto.TeacherDTO;
import com.example.team_project.teacher.mapper.TeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
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
      sqlSession.commit();
      System.out.println("새로운 Teacher 저장 성공");
    } else {
      System.out.println("새로운 Teacher 저장 실패");
    }
    sqlSession.close();
    return result;
  }

    // 로그인(선생님)
  public List<TeacherDTO> loginTeacher(Map<String, String> map) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
    List<TeacherDTO> result = mapper.loginTeacher(map);
    sqlSession.close();
    return result;
  }

  // 차소영님 여기 아래부터 작성 시작


  // 유지호님 여기 아래부터 작성 시작


}
