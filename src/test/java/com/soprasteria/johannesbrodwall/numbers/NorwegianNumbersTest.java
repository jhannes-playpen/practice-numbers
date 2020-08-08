package com.soprasteria.johannesbrodwall.numbers;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class NorwegianNumbersTest {
    @TestFactory
    List<DynamicTest> numberTests() {
        return List.of(
                testConvert("en", 1),
                testConvert("to", 2),
                testConvert("tre", 3),
                testConvert("tjue", 20),
                testConvert("tjueen", 21),
                testConvert("førtini", 49)
        );
    }

    private DynamicTest testConvert(String expected, int number) {
        return dynamicTest("return " + expected + " for " + number,
                () -> assertEquals(expected, toNorwegian(number)));
    }

    private String toNorwegian(int number) {
        Map<Integer, String> numbers = Map.of(1, "en",
                2, "to",
                3, "tre",
                9, "ni",
                20, "tjue",
                40, "førti"
        );
        if (number > 20 && number % 10 != 0) {
            return toNorwegian(number-number%10) + toNorwegian(number%10);
        }
        return numbers.get(number);
    }
}
