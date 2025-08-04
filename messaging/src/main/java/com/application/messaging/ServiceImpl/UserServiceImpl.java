package com.application.messaging.ServiceImpl;

import com.application.messaging.DTO.Request.UserRequest;
import com.application.messaging.DTO.Response.UserResponse;
import com.application.messaging.Entity.ContactList;
import com.application.messaging.Entity.User;
import com.application.messaging.Repository.ContactsRepository;
import com.application.messaging.Repository.UserRepository;
import com.application.messaging.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactsRepository contactsRepository;

    @Override
    public UserResponse loginDataSave(UserRequest userRequest) {
        User user=new User();
        user.setUsername(userRequest.getUsername());
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setMobileNumber(userRequest.getMobile_number());
     User user1= userRepository.save(user);

        ContactList contactList = new ContactList();
        contactList.setName("Self");
        contactList.setMobileNumber(userRequest.getMobile_number());
        contactList.setUserId(user1.getId());
        ContactList contactList1=contactsRepository.save(contactList);

        UserResponse userResponse=new UserResponse();
        userResponse.setUser_id(user1.getId());
        userResponse.setId(contactList.getUserId());
        userResponse.setName(user1.getName());
        userResponse.setEmail(user1.getEmail());
        userResponse.setMobileNumber(user1.getMobileNumber());
        userResponse.setUsername(user1.getUsername());
       return userResponse;
    }
}
