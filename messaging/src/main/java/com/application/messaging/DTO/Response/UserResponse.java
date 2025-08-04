package com.application.messaging.DTO.Response;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private Long user_id;
    private String name;
    private String username;
    private String email;
    private String mobileNumber;

}
