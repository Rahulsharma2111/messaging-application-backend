package com.application.messaging.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Entity
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    private String message;
    private String mobileNumber;
//    private boolean isMe;
    private String name;
    private Long senderId;
    private Long receiverId;
    @CreationTimestamp
    private Date createdAt;
    private Date deletedAt;
    @UpdateTimestamp
    private Date updatedAt;
}
