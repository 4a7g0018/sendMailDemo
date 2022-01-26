package com.yan.send.mail.sendMailDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailService {

    private JavaMailSender mailSender;

    @Autowired
    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void prepareAndSend(String recipient, String title, String message) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("yan19991203.home@gmail.com");
            messageHelper.setTo(recipient);
            messageHelper.setSubject(title);
            messageHelper.setText(message);
        };

        try {
            mailSender.send(messagePreparator);
            log.info("send success !!");
        } catch (MailException mex) {
            log.info("end error !!");
        }
    }
}
