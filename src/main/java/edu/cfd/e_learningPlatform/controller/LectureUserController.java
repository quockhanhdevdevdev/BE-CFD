package edu.cfd.e_learningPlatform.controller;

import edu.cfd.e_learningPlatform.dto.LectureUserDto;
import edu.cfd.e_learningPlatform.dto.response.LectureUserResponse;
import edu.cfd.e_learningPlatform.service.LectureUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/progress")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LectureUserController {

    LectureUserService lectureUserService;

    @GetMapping("/{userId}/{lectureId}")
    public ResponseEntity<List<LectureUserResponse>> getUserLecture(
            @PathVariable String userId, @PathVariable Long lectureId) {
        return ResponseEntity.ok(lectureUserService.findByUserAndLecture(lectureId, userId));
    }

    @PostMapping("/submitQuiz")
    public ResponseEntity<LectureUserDto> addProgess(@RequestBody LectureUserResponse lectureUserResponse) {
        return ResponseEntity.ok(lectureUserService.addProgress(lectureUserResponse));
    }
}
