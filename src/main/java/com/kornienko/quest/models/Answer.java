package com.kornienko.quest.models;

import lombok.Data;

@Data
public class Answer {
    private int id;
    private String title;
    private int question;
    private int result;
}
