package com.kornienko.quest.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kornienko.quest.models.Root;
import lombok.SneakyThrows;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionService implements Serializable {
    private final ObjectMapper objectMapper;

    public QuestionService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public Root readFromFile(String pathToJson) {
        Path path = Path.of(Objects.requireNonNull(
                getClass()
                        .getClassLoader()
                        .getResource(pathToJson))
                .toURI()
        );

        try(Stream<String> lines = Files.lines(path)) {
            String inputRoot = lines.collect(Collectors.joining("\n"));
            return objectMapper.readValue(inputRoot, Root.class);
        }
    }
}
