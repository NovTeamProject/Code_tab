package com.example.team_project.board.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardDTO {
    private int boardIdx; // boardIdx -> board_idx & board_idx -> boardIdx
    private int classIdx;
    private int studentIdx;
    private String studentName;
    private String title;
    private String content;
    private int visitcount;
    private LocalDateTime registerDate;

    public String getClassRegisterDateWithYearMonthDayHourMinute() {
        if (this.registerDate != null) {
            return this.registerDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } else {
            return "no date available";
        }
    }
}
