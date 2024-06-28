package com.kornienko.quest.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.kornienko.quest.models.Root;
import lombok.SneakyThrows;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionService {
    private ObjectMapper objectMapper;

    public QuestionService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public Root readFromFile(String pathToJson) {
        String expectedData = "Hello, world!";

        Path path = Path.of(getClass()
                .getClassLoader()
                .getResource(pathToJson)
                .toURI());

        Stream<String> lines = Files.lines(path);
        String inputRoot = lines.collect(Collectors.joining("\n"));
        return objectMapper.readValue(inputRoot, Root.class);
    }
}
