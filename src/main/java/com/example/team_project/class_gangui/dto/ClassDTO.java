package com.example.team_project.class_gangui.dto;

import com.example.team_project.lesson_sueop.dto.LessonDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClassDTO {
    private int classIdx;
    private String className;
    private String classExplain;
    private int teacherIdx;
    private LocalDateTime classRegisterDate;
    private int classTotalTime;
    private int classTotalLessonCount;
    private String classImageOriginalFilename;
    private String classImageSavedFilename;
    private int listenStudent;

    private List<LessonDTO> lessonList;

    public String getClassRegisterDateWithYearMonthDay() {
        if (this.classRegisterDate != null) {
            return this.classRegisterDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            return "no date available";
        }
    }

    public String getClassRegisterDateWithYearMonthDayHourMinute() {
        if (this.classRegisterDate != null) {
            return this.classRegisterDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } else {
            return "no date available";
        }
    }
}
