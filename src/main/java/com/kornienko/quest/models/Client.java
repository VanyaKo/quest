package com.kornienko.quest.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class Client implements Serializable {
    @Setter
    private String id;
    @Setter
    private String username;
    private int gameCount;

    public Client() {
        gameCount = 0;
        username = "DEFAULT_USER";
    }

    public void increaseGameCounter() {
        gameCount++;
    }

    public void resetGameCounter() {
        gameCount = 0;
    }
}
