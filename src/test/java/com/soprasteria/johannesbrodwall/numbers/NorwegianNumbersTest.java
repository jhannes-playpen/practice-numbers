package com.soprasteria.johannesbrodwall.numbers;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NorwegianNumbersTest {
    @TestFactory
    List<DynamicTest> numberTests() {
        return List.of(
                DynamicTest.dynamicTest("return tjue for 20", () -> assertEquals("tjue", toNorwegian(20)))
        );
    }

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
        Map<Integer, String> numbers = Map.of(1, "en", 2, "to", 3, "tre", 20, "tjue");
        return numbers.get(i);
    }
}
