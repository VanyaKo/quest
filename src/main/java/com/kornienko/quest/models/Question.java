package com.kornienko.quest.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Question {
    public final int id;
    public final String title;
    public final List<Integer> choices;
}