package com.kiberzoid.emailservice.web;

import com.kiberzoid.emailservice.model.Message;
import com.kiberzoid.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(EmailController.URL)
public class EmailController {
    public static final String URL = "/api/email";

    @Autowired
    public EmailService service;

    @PostMapping(value = "/message", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendMessage(@RequestPart("msg") @Valid Message msg,
                            @RequestPart(value = "attachment", required = false) List<MultipartFile> attachment) {
        msg.setAttachment(attachment);
        service.sendEmail(msg);
    }
}
