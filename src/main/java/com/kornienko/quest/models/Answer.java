package com.kornienko.quest.models;

import lombok.Data;

@Data
public class Answer {
    private int id;
    private String title;
    private int questionId;
    private int resultId;

    public Answer() {
        id = -1;
        questionId = -1;
        resultId = -1;
    }
}
