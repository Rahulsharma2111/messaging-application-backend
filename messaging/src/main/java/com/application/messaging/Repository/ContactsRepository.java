package com.application.messaging.Repository;

import com.application.messaging.Entity.ContactList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<ContactList,Long> {
    @Query(value = "Select * from contact_list where user_id=:userId", nativeQuery = true)
    List<ContactList> getAllContactByUserId(@Param("userId") Long userId);
}
