package edu.cfd.e_learningPlatform.service;

import java.util.List;

import edu.cfd.e_learningPlatform.dto.request.MessageRequest;
import edu.cfd.e_learningPlatform.dto.response.MessageResponse;

public interface MessageService {
    List<MessageResponse> getMessages(String idUserTo, String idUserFrom);

    MessageResponse addMessage(MessageRequest request);
}
