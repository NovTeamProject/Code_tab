package com.example.team_project.comment.mapper;


import com.example.team_project.comment.dto.CommentDTO;

import java.util.List;

public interface CommentMapper {
    List<CommentDTO> selectCommentsByBoardIdx(int CommentIdx);
    int insertComment(CommentDTO dto);
}
