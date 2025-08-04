package com.application.messaging.DTO.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CustomResponse {

    public static <T>ResponseEntity<Map>ok(T data){

        Map metaData=new HashMap<>();
        metaData.put("status",200);
        metaData.put("error",false);
        metaData.put("message","success");

        Map<String, Object> response=new HashMap<>();
        response.put("data",data);
        response.put("metaData",metaData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//200 for successful GET requests
//201 for successful creation
//204 for successful deletion with no content
//400 for client errors
//401/403 for authentication/authorization errors
//404 for not found resources
//500 for server errors

}
