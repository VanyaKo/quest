package com.kornienko.quest.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

class JsonServiceTest {

    @Test
    void readFromFile_shouldThrowNullPointerException_whenNullInput() {
        ObjectMapper mock = Mockito.mock(ObjectMapper.class);
        assertThrows(NullPointerException.class,
                () -> new JsonService(mock).readFromFile(null));
    }
}