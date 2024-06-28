package com.kornienko.quest.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Result {
    public final int id;
    public final String title;
    public final boolean failed;
    public final boolean success;
}
