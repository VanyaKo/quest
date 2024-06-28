package com.kornienko.quest.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Root {
    private final List<Question> questions;
    private final List<Choice> choices;
    private final List<Result> results;
}