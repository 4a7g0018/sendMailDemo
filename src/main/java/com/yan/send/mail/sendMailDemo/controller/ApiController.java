package com.yan.send.mail.sendMailDemo.controller;

import com.yan.send.mail.sendMailDemo.model.Email;
import com.yan.send.mail.sendMailDemo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MailService mailService;

    @PostMapping("send_main")
    public ResponseEntity<?> sendMail(Email email){
        mailService.prepareAndSend(email.getRecipient(),email.getTitle(),email.getGetMessage());
        return ResponseEntity.ok(email);
    }
}
