package com.kornienko.quest.models;

import com.kornienko.quest.consts.Consts;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private int id;
    private String title;
    private boolean failed;
    private boolean success;

    private Result() {
        id = Consts.DEFAULT_ID;
    }
}
