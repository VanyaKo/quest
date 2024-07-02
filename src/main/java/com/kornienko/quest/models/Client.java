package com.kornienko.quest.models;

import lombok.Getter;
import lombok.Setter;

public class Client {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String username;
    @Getter
    private int gameCount = 0;

    public void increaseGameCounter() {
        gameCount++;
    }

    public void resetGameCounter() {
        gameCount = 0;
    }
}
