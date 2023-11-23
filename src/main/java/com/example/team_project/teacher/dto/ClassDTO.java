package com.example.team_project.teacher.dto;

import lombok.*;

import java.time.LocalDateTime;
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
}
