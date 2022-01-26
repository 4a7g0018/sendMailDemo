package com.yan.send.mail.sendMailDemo.service;

import com.yan.send.mail.sendMailDemo.model.Users;
import com.yan.send.mail.sendMailDemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Slf4j
public class UsersService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Users user = userRepository.findByUserName(username);
            return new User(user.getUserName(), user.getPassword(), Collections.emptyList());
        }catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("Username is wrong.");
        }
    }

    public Users saveUser(Users users){
        try {
            return userRepository.save(users);
        }catch (Exception ex){
            log.info("create error");
        }
        return null;
    }
}
