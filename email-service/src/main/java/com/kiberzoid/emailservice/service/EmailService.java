package com.kiberzoid.emailservice.service;

import com.kiberzoid.emailservice.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public static final Logger LOG = LoggerFactory.getLogger(EmailService.class);

    public EmailService() {
    }

    public void sendEmail(Message msg) {
        Message m = new Message();
        LOG.info("Email {} was sent", msg);
    }
}
