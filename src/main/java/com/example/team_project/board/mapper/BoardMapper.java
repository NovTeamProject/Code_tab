package com.example.team_project.board.mapper;

import com.example.team_project.board.dto.BoardDTO;

import java.util.List;
import java.util.Map;

public interface BoardMapper {
    int selectCount(Map<String, Object> map);

    List<BoardDTO> selectListPage(Map<String, Object> map);

    int insertWrite(BoardDTO dto);

    BoardDTO selectView(String boardIdx);

    int updateVisitCount(String boardIdx);

    int deletePost(String boardIdx);

    int updatePost(BoardDTO dto);
}
