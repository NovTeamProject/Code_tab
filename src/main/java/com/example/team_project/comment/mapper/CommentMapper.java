package com.example.team_project.comment.mapper;


import com.example.team_project.board.dto.BoardDTO;
import com.example.team_project.comment.dto.CommentDTO;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    List<CommentDTO> selectCommentsByBoardIdx(int CommentIdx);
    int insertComment(CommentDTO dto);
}
