package com.application.messaging.Controller;

import com.application.messaging.DTO.Request.ContactsRequest;
import com.application.messaging.DTO.Response.CustomResponse;
import com.application.messaging.Entity.ContactList;
import com.application.messaging.Service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contacts")
@Controller
@CrossOrigin("*")
public class ContactsController {
    @Autowired
    private ContactsService contactsService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewContacts(@RequestBody ContactsRequest contactsRequest) {
        contactsService.addNewContacts(contactsRequest);
        return CustomResponse.ok("added");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllContacts(@PathVariable Long userId){
        List<ContactList> response= contactsService.getAllContactsDetailsByUserId(userId);
        return CustomResponse.ok(response);
    }

}