package com.example.team_project.student.dao;

import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import com.example.team_project.student.dto.StudentDTO;
import com.example.team_project.student.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class StudentDAO {
    // 변재혁님 여기 아래부터 작성 시작


    // 남원우님 여기 아래부터 작성 시작

    // 회원가입(학생)
    public int joinStudent(StudentDTO dto){
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
    int result = mapper.joinStudent(dto);
    if (result == 1) {
      sqlSession.commit();
      System.out.println("새로운 Student 저장 성공");
    } else {
      System.out.println("새로운 Student 저장 실패");
    }
    sqlSession.close();
    return result;
  }
    // 로그인(학생)
    public boolean loginStudent(String studentId, String studentPassword) {
      Map<String, String> map = new HashMap<>();
        System.out.println(studentId+".."+studentPassword); //여기까지옴
      map.put("studentId", studentId);
      map.put("studentPassword", studentPassword);

      SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();    //여기가 에러sql문 에러인거같음
      StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
      int result = mapper.loginStudent(map);
       
      if (result == 1) {
        return true;
      } else {
        return false;
      }
    }

  public StudentDTO idCheck(String studentId) {

      SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
      StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
      StudentDTO result = mapper.idCheck(studentId);
      sqlSession.close();
      return result;

  }

    // 차소영님 여기 아래부터 작성 시작


    // 유지호님 여기 아래부터 작성 시작


}
