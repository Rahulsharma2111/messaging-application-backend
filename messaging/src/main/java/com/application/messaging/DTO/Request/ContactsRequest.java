package com.application.messaging.DTO.Request;

import lombok.Data;

@Data
public class ContactsRequest {
    private String mobile_number;
    private String name;
    private Long user_id;
}
