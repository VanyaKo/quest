package com.kornienko.quest.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Choice {
    public final int id;
    public final String title;
    public final int question;
    public final int result;
}
