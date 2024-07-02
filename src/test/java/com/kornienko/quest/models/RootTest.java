package com.kornienko.quest.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kornienko.quest.consts.Consts;
import com.kornienko.quest.services.JsonService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RootTest {
    Root root;

    @BeforeAll
    void init() {
        root = new JsonService(new ObjectMapper()).readFromFile(Consts.PATH_TO_JSON);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    void getAnswerByQuestionId_shouldThrowNoSuchElementException_whenIncorrectID(int id) {
        assertThrows(NoSuchElementException.class,
                () -> root.getAnswerByQuestionId(id));
    }
}