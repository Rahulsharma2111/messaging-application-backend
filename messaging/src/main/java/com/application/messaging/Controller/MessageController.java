package com.application.messaging.Controller;

import com.application.messaging.Entity.Message;
import com.application.messaging.Entity.Messages;
import com.application.messaging.Repository.ChatRepository;
import com.application.messaging.ServiceImpl.WebSocketSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class MessageController {
    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private WebSocketSessionService webSocketSessionService;
    @MessageMapping("/chat.private.send")
    public void sendPrivateMessage(@Payload Message message) {
        // Deliver the private message
        webSocketSessionService.sendPrivateMessage(
                message.getFrom(),
                message.getTo(),
                message.getContent()
        );
        Messages messages=new Messages();
        messages.setMessage(message.getContent());
        messages.setSenderId(Long.valueOf(message.getFrom()));
        messages.setReceiverId(Long.valueOf(message.getTo()));
        chatRepository.save(messages);
    }

    @MessageMapping("/chat.register")
    public void registerUser(@Payload String userId, SimpMessageHeaderAccessor headerAccessor) {
        String sessionId = headerAccessor.getSessionId();
        webSocketSessionService.registerUser(userId, sessionId);
        headerAccessor.getSessionAttributes().put("username", userId);
    }

//    @MessageMapping("/chat") // Handles messages sent to /app/chat
//    @SendTo("/topic/messages") // Sends the return value to /topic/messages
//    public Message sendMessage(Message message) {
//        // You can process the message here (save to DB, etc.)
//        return message;
//    }
//
//
//    @MessageMapping("/chat.private.send")
//    @SendToUser("/queue/messages")
//    public Message sendPrivateMessage(@Payload Message message, Principal principal) {
//        message.setFrom(message.getFrom());
//        message.setTimestamp(LocalDateTime.now());
//        return message;
//    }
//
//        @MessageMapping("/chat.register")
//        public void registerUser(@Payload String username, SimpMessageHeaderAccessor headerAccessor) {
//            String sessionId = headerAccessor.getSessionId();
//            // Associate username with session (you might want to store this in a service)
//            // This is needed to map usernames to WebSocket sessions
//    }
}