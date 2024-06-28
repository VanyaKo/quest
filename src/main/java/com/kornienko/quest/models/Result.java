package com.kornienko.quest.models;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public class Result {
    private int id;
    private String title;
    private boolean failed;
    private boolean success;
}
