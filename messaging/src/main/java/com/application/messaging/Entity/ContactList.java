package com.application.messaging.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "contact_list")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private Long userId; // user table id to identify, who has this mobile number
    private String mobileNumber;
    private String name;
    @CreationTimestamp
    private Date createdAt;
    private Date deletedAt;
    @UpdateTimestamp
    private Date updatedAt;
}
