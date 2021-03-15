package com.kiberzoid.pushservice.web;

import com.kiberzoid.pushservice.model.Message;
import com.kiberzoid.pushservice.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(PushController.URL)
public class PushController {
    public static final String URL = "/api/push";

    @Autowired
    private PushService service;

    @PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendMessage(@Valid @RequestBody Message msg) {
        service.sendPush(msg);
    }
}
