package com.example.team_project.teacher.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LessonDTO {
    private int lessonIdx;
    private String lessonName;
    private int lessonSequence;
    private int classIdx;
    private int lessonTime;
    private String lessonOriginalFilename;
    private String lessonSavedFilename;
}
