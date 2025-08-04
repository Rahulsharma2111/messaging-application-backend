package com.application.messaging.Controller;

import com.application.messaging.DTO.Request.UserRequest;
import com.application.messaging.DTO.Response.CustomResponse;
import com.application.messaging.DTO.Response.UserResponse;
import com.application.messaging.Entity.User;
import com.application.messaging.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Controller
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRequest userRequest){
        UserResponse user= userService.loginDataSave(userRequest);
        return CustomResponse.ok(user);
    }

}
