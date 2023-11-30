package com.example.team_project.comment.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class CommentDTO {
    private int commentIdx;
    private int boardIdx;
    private int personIdx;
    private int personType;
    private String personName;
    private String content;
    private LocalDateTime registerDate;
}
