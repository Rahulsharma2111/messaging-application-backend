package com.application.messaging.ServiceImpl;

import com.application.messaging.DTO.Request.ContactsRequest;
import com.application.messaging.Entity.ContactList;
import com.application.messaging.Repository.ContactsRepository;
import com.application.messaging.Service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

    @Override
    public void addNewContacts(ContactsRequest contactsRequest) {
        ContactList contactList = new ContactList();
        contactList.setName(contactsRequest.getName());
        contactList.setMobileNumber(contactsRequest.getMobile_number());
        contactList.setUserId(contactsRequest.getUser_id());
        contactsRepository.save(contactList);

    }

    @Override
    public List<ContactList> getAllContactsDetailsByUserId(Long userId) {
        List<ContactList> contactList=contactsRepository.getAllContactByUserId(userId);
        //     avatar: '/images/bajanLal.jpeg',
        //     lastMessage: 'when you free, call me?',
        //     time: '1 month ago',
        //     unread: 2
     return contactList;

    }
}
