package edu.cfd.e_learningPlatform.controller;

import java.util.List;

import edu.cfd.e_learningPlatform.dto.response.EnrollCourseResponse;
import edu.cfd.e_learningPlatform.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import edu.cfd.e_learningPlatform.dto.request.MessageRequest;
import edu.cfd.e_learningPlatform.dto.response.MessageResponse;
import edu.cfd.e_learningPlatform.service.MessageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController()
@RequestMapping("/messages")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MessageController {
    MessageService messageService;
    CourseService courseService;

    @GetMapping("toUser/{idUserTo}/{idUserFrom}")
    public ResponseEntity<List<MessageResponse>> getMessagesToUser(
            @PathVariable String idUserTo, @PathVariable String idUserFrom) {
        return ResponseEntity.ok(messageService.getMessagesToUser(idUserTo, idUserFrom));
    }

    @GetMapping("toCourse/{idCourse}")
    public ResponseEntity<List<MessageResponse>> getMessagesToCourse(
            @PathVariable Long idCourse) {
        return ResponseEntity.ok(messageService.getMessagesToCourse(idCourse));
    }

    @MessageMapping("/messages/send")
    @SendTo("/topic/messages")
    public MessageResponse sendMessage(@RequestBody MessageRequest messageRequest) {
        return messageService.addMessage(messageRequest);
    }

    @MessageMapping("/messages/delete")
    @SendTo("/topic/delete")
    public Long deleteMessage(@RequestBody MessageRequest messageRequest) {
        return messageService.deleteMessage(messageRequest.getId());
    }

    @GetMapping("/getEnrollCourse/{idStudent}")
    public ResponseEntity<List<EnrollCourseResponse>> getEnrollCourse(@PathVariable String idStudent) {
        return ResponseEntity.ok(courseService.getEnrollCourses(idStudent));
    }

    @GetMapping("/getCourseIntructor/{idIntructor}")
    public ResponseEntity<List<EnrollCourseResponse>> getCourseIntructor(@PathVariable String idIntructor) {
        return ResponseEntity.ok(courseService.getCoursesIntructor(idIntructor));
    }
}
