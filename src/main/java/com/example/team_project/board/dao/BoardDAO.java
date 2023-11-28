package com.example.team_project.board.dao;

import com.example.team_project.board.dto.BoardDTO;
import com.example.team_project.board.mapper.BoardMapper;
import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BoardDAO {

    public int selectCount(Map<String, Object> map) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        int result = mapper.selectCount(map);
        sqlSession.close();
        return result;
    }

    public List<BoardDTO> selectListPage(Map<String, Object> map) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        List<BoardDTO> result = mapper.selectListPage(map);
        sqlSession.close();
        return result;
    }

    public int insertWrite(BoardDTO dto) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        int result = mapper.insertWrite(dto);
        if (result == 1) {
            sqlSession.commit();
            System.out.println("board 저장 성공");
        } else {
            System.out.println("board 저장 실패");
        }
        sqlSession.close();
        return result;
    }

    public BoardDTO selectView(String idx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        BoardDTO dto = mapper.selectView(idx);
        sqlSession.close();
        return dto;
    }

    public void updateVisitCount(String idx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        int result = mapper.updateVisitCount(idx);
        System.out.println("update query result val = " + result);
        if (result == 1) {
            sqlSession.commit();
        } else {
            System.out.println("조회수 증가 중 오류 발생");
        }
        sqlSession.close();
    }

    public int deletePost(String idx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        int result = mapper.deletePost(idx);
        if (result == 1) {
            sqlSession.commit();
        } else {
            System.out.println("board 삭제 중 오류 발생");
        }
        return result;
    }

    public int updatePost(BoardDTO dto) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        int result = mapper.updatePost(dto);
        if (result == 1) {
            sqlSession.commit();
        } else {
            System.out.println("board update 중 오류 발생");
        }
        sqlSession.commit();
        return result;
    }
}
