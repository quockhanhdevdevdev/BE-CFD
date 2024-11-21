package edu.cfd.e_learningPlatform.service;

import java.util.List;

import edu.cfd.e_learningPlatform.dto.request.MessageRequest;
import edu.cfd.e_learningPlatform.dto.response.MessageResponse;

public interface MessageService {
    List<MessageResponse> getMessagesToUser(String idUserTo, String idUserFrom);
    List<MessageResponse> getMessagesToCourse(Long idCourse);
    MessageResponse addMessage(MessageRequest request);
    Long deleteMessage(Long idMessage);
}
