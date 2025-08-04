package com.application.messaging.Service;

import com.application.messaging.DTO.Request.MessageRequest;
import com.application.messaging.DTO.Response.ChatResponse;
import com.application.messaging.Entity.Messages;

import java.util.List;

public interface ChatService {
    void sendMessage(MessageRequest messageRequest);

    List<ChatResponse> getAllChatsByUserId(Long userId,Long senderId);
}
