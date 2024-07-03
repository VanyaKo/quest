package com.kornienko.quest.models;

import com.kornienko.quest.consts.Consts;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Question implements Serializable {
    private int id;
    private String title;
    private List<Integer> answers;

    private Question() {
        id = Consts.DEFAULT_ID;
    }
}