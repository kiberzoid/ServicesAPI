package com.kiberzoid.smsservice;

import com.kiberzoid.smsservice.model.Message;

import java.util.Arrays;
import java.util.HashSet;

public class TestData {
    public static final Message MSG = new Message(
            new HashSet<>(Arrays.asList("79502992059", "79012112109", "79876556789")),
            "Требуется обновление");
    public static final Message BAD_MSG = new Message();
}
