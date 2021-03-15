package com.kiberzoid.smsservice.service;

import com.kiberzoid.smsservice.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    public static final Logger LOG = LoggerFactory.getLogger(SmsService.class);

    public SmsService() {
    }

    public void sendSms(Message msg) {
        LOG.info("SMS {} was sent", msg);
    }
}