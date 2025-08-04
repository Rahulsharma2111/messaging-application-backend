package com.application.messaging.Repository;

import com.application.messaging.Entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Messages,Long> {
    @Query(value = "SELECT * FROM messages WHERE (sender_id = :senderId AND receiver_id = :receiverId) " +
            "OR (sender_id = :receiverId AND receiver_id = :senderId);", nativeQuery = true)
    List<Messages> findAllChatsBySenderId(@Param("receiverId") Long receiverId,@Param("senderId") Long senderId);
}
