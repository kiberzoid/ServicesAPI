package com.kiberzoid.pushservice;

import com.kiberzoid.pushservice.model.Message;

import java.util.Set;

public class TestData {
    public static final Message MSG = new Message("Выпуск новостей", "Начало в 15:00",
            Set.of("ID-TOKEN-1234567899", "ID-TOKEN-1235567899", "ID-TOKEN-1214567899"));
    public static final Message BAD_MSG = new Message();
}
