package com.yan.send.mail.sendMailDemo.repository;

import com.yan.send.mail.sendMailDemo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUserName(String userName);
}
