package com.example.team_project.comment.dao;

import com.example.team_project.board.dto.BoardDTO;
import com.example.team_project.board.mapper.BoardMapper;
import com.example.team_project.comment.dto.CommentDTO;
import com.example.team_project.comment.mapper.CommentMapper;
import com.example.team_project.mybatis.factory.MyBatisSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class CommentDAO {

    public List<CommentDTO> selectCommentsByBoardIdx(int boardIdx) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
        List<CommentDTO> comments = mapper.selectCommentsByBoardIdx(boardIdx);
        sqlSession.close();
        return comments;
    }

    public int insertComment(CommentDTO dto) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
        int result = mapper.insertComment(dto);
        if (result == 1) {
            sqlSession.commit();
            System.out.println("답변 저장 성공");
        } else {
            System.out.println("답변 저장 실패");
        }
        sqlSession.close();
        return result;
    }


}
