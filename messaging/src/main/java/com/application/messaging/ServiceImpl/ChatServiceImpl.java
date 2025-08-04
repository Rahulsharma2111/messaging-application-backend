package com.application.messaging.ServiceImpl;

import com.application.messaging.DTO.Request.MessageRequest;
import com.application.messaging.DTO.Response.ChatResponse;
import com.application.messaging.Entity.Message;
import com.application.messaging.Entity.Messages;
import com.application.messaging.Repository.ChatRepository;
import com.application.messaging.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatRepository chatRepository;
    @Override
    public void sendMessage(MessageRequest messageRequest) {
        Messages message=new Messages();
        message.setMessage(messageRequest.getMessage());
        message.setMobileNumber(messageRequest.getMobileNumber());
        message.setSenderId(messageRequest.getSender_id());
//        message.setMe();
        message.setReceiverId(messageRequest.getReceiver_id());
        chatRepository.save(message);
    }

    @Override
    public List<ChatResponse> getAllChatsByUserId(Long userId,Long senderId) {
        Long reciverId=userId;
        List<Messages> messages= chatRepository.findAllChatsBySenderId(reciverId,senderId);
        List<ChatResponse> chatList=new ArrayList<>();
        for (Messages mess:messages) {
            ChatResponse chatResponse=new ChatResponse();
            chatResponse.setMessageId(mess.getMessageId());
            chatResponse.setText(mess.getMessage());
            chatResponse.setMobileNumber(mess.getMobileNumber());
            if (senderId==mess.getSenderId()){
                chatResponse.setSent(true);
            }else {
                chatResponse.setSent(false);
            }
            chatResponse.setName(mess.getName());
            chatResponse.setSenderId(mess.getSenderId());
            chatResponse.setReceiverId(mess.getReceiverId());
            chatResponse.setUpdatedAt(mess.getUpdatedAt());


            chatList.add(chatResponse);
        }

        return chatList;
    }
}
