package com.kiberzoid.smsservice.web;

import com.kiberzoid.smsservice.model.Message;
import com.kiberzoid.smsservice.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(SmsController.URL)
public class SmsController {
    public static final String URL = "/api/sms";

    @Autowired
    private SmsService service;

    @PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendMessage(@Valid @RequestBody Message msg) {
        service.sendSms(msg);
    }
}
