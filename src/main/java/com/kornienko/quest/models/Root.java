package com.kornienko.quest.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Root implements Serializable {
    private List<Question> questions;
    private List<Answer> answers;
    private List<Result> results;

    public Answer getAnswerByQuestionId(int id) {
        return answers.stream()
                .filter(answer -> answer.getId() == id)
                .findFirst()
                .orElseThrow();
    }
}