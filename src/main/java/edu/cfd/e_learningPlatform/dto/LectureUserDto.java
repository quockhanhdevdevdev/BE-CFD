package edu.cfd.e_learningPlatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureUserDto {
    private Long id;
    private String userId;
    private Long lectureId;
    private String choseOption;
    private LocalDateTime updateAt;
    private boolean doneVideo;
    private boolean doneAssignment;
    private String urlFileAssigment;
    private boolean doneQuiz;
    private boolean status;
}
