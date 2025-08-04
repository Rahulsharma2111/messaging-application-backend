package com.application.messaging.DTO.Request;

import lombok.Data;

@Data
public class MessageRequest {
    private String message;
    private String mobileNumber;
    private Long sender_id;
    private Long receiver_id;
}
