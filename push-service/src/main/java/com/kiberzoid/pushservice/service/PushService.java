package com.kiberzoid.pushservice.service;

import com.kiberzoid.pushservice.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PushService {
    public static final Logger LOG = LoggerFactory.getLogger(PushService.class);

    public PushService() {
    }

    public void sendPush(Message msg) {
        LOG.info("Push {} was sent", msg);
    }
}
