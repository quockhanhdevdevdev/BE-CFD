package edu.cfd.e_learningPlatform.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class LectureUserResponse {
    private Long id;
    private String userId;
    private Long lectureId;
    private List<Long> choseOption;
    private LocalDateTime updateAt;
    private boolean doneVideo;
    private boolean doneAssignment;
    private String urlFileAssigment;
    private boolean doneQuiz;
    private boolean status;
}
