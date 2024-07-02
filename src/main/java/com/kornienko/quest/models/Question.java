package com.kornienko.quest.models;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    private int id;
    private String title;
    private List<Integer> answers;

    private Question() {
        id = -1;
    }
}