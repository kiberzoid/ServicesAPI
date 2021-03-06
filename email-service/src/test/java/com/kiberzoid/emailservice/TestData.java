package com.kiberzoid.emailservice;

import com.kiberzoid.emailservice.model.Message;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestData {
    public static final Message MSG = new Message("from@mail.ru",
            new HashSet<String>(Arrays.asList("copy1@mail.ru", "copy2@mail.ru")),
            "test message", "this is message for test ");
    public static final Message BAD_MSG = new Message();
}
