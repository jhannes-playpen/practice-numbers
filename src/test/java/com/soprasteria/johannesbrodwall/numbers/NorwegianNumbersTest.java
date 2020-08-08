package com.soprasteria.johannesbrodwall.numbers;

import org.junit.jupiter.api.Test;

import java.util.Map;

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

    @Test
    void shouldReturnTreForThree() {
        assertEquals("tre", toNorwegian(3));
    }

    private String toNorwegian(int i) {
        Map<Integer, String> numbers = Map.of(1, "en", 2, "to");
        return numbers.get(i);
    }
}
