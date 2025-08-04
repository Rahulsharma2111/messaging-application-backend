package com.application.messaging.ServiceImpl;

import com.application.messaging.Entity.Message;
import com.application.messaging.Repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WebSocketSessionService {

    private final Map<String, String> userSessionMap = new ConcurrentHashMap<>();
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketSessionService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void registerUser(String username, String sessionId) {
        // Save mapping of username to itself (Spring uses username for /user/{username}/queue)
        userSessionMap.put(username, username);
        System.out.println("Registered user: " + username + " with session " + sessionId);
    }

    public void sendPrivateMessage(String from, String to, String content) {
        if (userSessionMap.containsKey(to)) {
            Message message = new Message(from, to, content, LocalDateTime.now());
            messagingTemplate.convertAndSendToUser(
                    to,                 // recipient username
                    "/queue/messages",  // destination
                    message
            );
        } else {
            System.out.println("User not connected: " + to);
        }
    }
}
