package com.example.team_project.exam.dao;

import com.example.team_project.exam.mapper.ExamMapper;
import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import org.apache.ibatis.session.SqlSession;
public class ExamDAO {

  public int ExamAnswer(int examId,int examNum, int examAnswer){
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    ExamMapper mapper = sqlSession.getMapper(ExamMapper.class);
    int result = mapper.answerTable(examId,examNum,examAnswer);
    sqlSession.close();
    return result;
  }

}
