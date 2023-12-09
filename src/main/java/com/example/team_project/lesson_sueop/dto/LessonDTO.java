package com.example.team_project.lesson_sueop.dto;

import com.example.team_project.utils.TimeConverter;
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

    public String getHourMinSec() {
        return TimeConverter.convertTime(this.lessonTime);
    }
}
