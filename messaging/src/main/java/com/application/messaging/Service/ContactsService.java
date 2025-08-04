package com.application.messaging.Service;

import com.application.messaging.DTO.Request.ContactsRequest;
import com.application.messaging.Entity.ContactList;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ContactsService {
    void addNewContacts(ContactsRequest contactsRequest);

    List<ContactList> getAllContactsDetailsByUserId(Long userId);
}
