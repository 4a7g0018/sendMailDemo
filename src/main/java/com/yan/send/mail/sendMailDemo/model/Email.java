package com.yan.send.mail.sendMailDemo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Email {
    private String recipient;
    private String title;
    private String getMessage;
}
