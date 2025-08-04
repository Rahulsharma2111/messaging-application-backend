package com.application.messaging.Service;

import com.application.messaging.DTO.Request.UserRequest;
import com.application.messaging.DTO.Response.UserResponse;
import com.application.messaging.Entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    UserResponse loginDataSave(UserRequest userRequest);
}
