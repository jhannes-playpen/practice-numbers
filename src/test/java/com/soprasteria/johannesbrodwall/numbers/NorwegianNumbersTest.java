package com.soprasteria.johannesbrodwall.numbers;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

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
                testConvert("førtini", 49),
                testConvert("ett hundre", 100),
                testConvert("ett hundre og femtifem", 155),
                testConvert("to hundre", 200),
                testConvert("seks hundre og sekstiåtte", 668),
                testConvert("ett tusen", 1000),
                testConvert("to tusen", 2000),
                testConvert("tre tusen og ti", 3010),
                testConvert("elleve tusen syv hundre og tolv", 11_712),
                testConvert("ett hundre og tjuetre tusen ett hundre", 123_100),
                testConvert("ni hundre og åttisyv millioner seks hundre og femtifire tusen tre hundre og tjueen", 987_654_321)
        );
    }

    private DynamicTest testConvert(String expected, int number) {
        return dynamicTest("return " + expected + " for " + number,
                () -> assertEquals(expected, NorwegianNumbers.toNorwegian(number)));
    }

}
