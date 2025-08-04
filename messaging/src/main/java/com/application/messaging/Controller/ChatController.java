package com.application.messaging.Controller;

import com.application.messaging.DTO.Request.MessageRequest;
import com.application.messaging.DTO.Response.ChatResponse;
import com.application.messaging.DTO.Response.CustomResponse;
import com.application.messaging.Entity.Messages;
import com.application.messaging.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/chats")
@RestController
@CrossOrigin("*")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody MessageRequest messageRequest){
        chatService.sendMessage(messageRequest);
        return CustomResponse.ok("Message sent successfully");
    }

    @GetMapping("/{userId}/{senderId}")
    public ResponseEntity<?> getAllMessages(@PathVariable("userId") Long userId,@PathVariable Long senderId){
        List<ChatResponse> chats= chatService.getAllChatsByUserId(userId,senderId);
        return CustomResponse.ok(chats);
    }

}
