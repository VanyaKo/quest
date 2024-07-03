package com.kornienko.quest.models;

import com.kornienko.quest.consts.Consts;
import lombok.Data;

import java.io.Serializable;

@Data
public class Answer implements Serializable {
    private int id;
    private String title;
    private int questionId;
    private int resultId;

    public Answer() {
        id = Consts.DEFAULT_ID;
        questionId = Consts.DEFAULT_ID;
        resultId = Consts.DEFAULT_ID;
    }
}
