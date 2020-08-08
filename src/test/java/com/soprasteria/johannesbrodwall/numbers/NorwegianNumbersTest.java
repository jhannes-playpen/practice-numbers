package com.soprasteria.johannesbrodwall.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NorwegianNumbersTest {
    @Test
    void shouldReturnEnForOne() {
        assertEquals("en", toNorwegian(1));
    }

    @Test
    void shouldReturnToForTwo() {
        assertEquals("to", toNorwegian(2));
    }

    private String toNorwegian(int i) {
        return "en";
    }
}
