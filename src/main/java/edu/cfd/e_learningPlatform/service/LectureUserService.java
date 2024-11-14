package edu.cfd.e_learningPlatform.service;

import edu.cfd.e_learningPlatform.dto.LectureUserDto;
import edu.cfd.e_learningPlatform.dto.response.LectureUserResponse;

import java.util.List;

public interface LectureUserService {
    List<LectureUserResponse> findByUserAndLecture(Long lectureId, String userId);

    LectureUserDto addProgress(LectureUserResponse lectureUserResponse);

    LectureUserDto updateProgress(LectureUserResponse lectureUserResponse);
}
