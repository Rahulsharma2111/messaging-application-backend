package com.application.messaging.DTO.Response;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
public class ChatResponse {
    private Long messageId;
    private String text;
    private String mobileNumber;
    private boolean isSent;
    private String name;
    private Long senderId;
    private Long receiverId;
    private Date updatedAt;

}
