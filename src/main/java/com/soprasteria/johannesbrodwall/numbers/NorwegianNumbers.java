package com.soprasteria.johannesbrodwall.numbers;

import java.util.HashMap;
import java.util.Map;

public class NorwegianNumbers {

    private static Map<Integer, String> NUMBERS = new HashMap<>();

    static {
        NUMBERS.put(1, "en");
        NUMBERS.put(2, "to");
        NUMBERS.put(3, "tre");
        NUMBERS.put(4, "fire");
        NUMBERS.put(5, "fem");
        NUMBERS.put(6, "seks");
        NUMBERS.put(7, "syv");
        NUMBERS.put(8, "åtte");
        NUMBERS.put(9, "ni");
        NUMBERS.put(10, "ti");
        NUMBERS.put(11, "elleve");
        NUMBERS.put(12, "tolv");
        NUMBERS.put(20, "tjue");
        NUMBERS.put(40, "førti");
        NUMBERS.put(50, "femti");
        NUMBERS.put(60, "seksti");
        NUMBERS.put(80, "åtti");
        NUMBERS.put(100, "ett hundre");
        NUMBERS.put(1000, "ett tusen");
    }

    public static String toNorwegian(int number) {
        if (NUMBERS.containsKey(number)) {
            return NUMBERS.get(number);
        }
        if (number > 1_000_000) {
            return convertBigNumber(number, 1_000_000, "millioner");
        }
        if (number > 1000) {
            return convertBigNumber(number, 1000, "tusen");
        }
        if (number > 100) {
            return convertBigNumber(number, 100, "hundre");
        }
        if (number > 20 && number % 10 != 0) {
            return toNorwegian(number - number % 10) + toNorwegian(number % 10);
        }
        throw new IllegalArgumentException("Don't know how to deal with " + number);
    }

    private static String convertBigNumber(int number, int bigNumber, String bigNumberName) {
        if (number % bigNumber == 0) {
            return toNorwegian(number / bigNumber) + " " + bigNumberName;
        } else if (number % bigNumber >= 100) {
            return toNorwegian(number - number % bigNumber) + " " + toNorwegian(number % bigNumber);
        } else {
            return toNorwegian(number - number % bigNumber) + " og " + toNorwegian(number % bigNumber);
        }
    }
}
