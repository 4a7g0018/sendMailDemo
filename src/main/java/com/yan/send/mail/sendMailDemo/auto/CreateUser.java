package com.yan.send.mail.sendMailDemo.auto;

import com.yan.send.mail.sendMailDemo.model.Users;
import com.yan.send.mail.sendMailDemo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CreateUser implements CommandLineRunner {

    @Autowired
    private UsersService usersService;

    @Override
    public void run(String... args) throws Exception {
        try {
            Users user =Users.builder().userName("yan19991203").password("a0925511706").email("yan19991203@gmail.com").build();
            usersService.saveUser(user);
            log.info("auto create user 'success'");
        }catch (Exception e){
            log.info("auto create user 'fail'");
        }

    }
}
