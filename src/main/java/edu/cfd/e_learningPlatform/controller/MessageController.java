package edu.cfd.e_learningPlatform.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{idUserTo}/{idUserFrom}")
    public ResponseEntity<List<MessageResponse>> getMessages(
            @PathVariable String idUserTo, @PathVariable String idUserFrom) {
        return ResponseEntity.ok(messageService.getMessages(idUserTo, idUserFrom));
    }

    @PostMapping("/send")
    public ResponseEntity<MessageResponse> sendMessage(@RequestBody MessageRequest messageRequest) {
        return ResponseEntity.ok(messageService.addMessage(messageRequest));
    }
}
