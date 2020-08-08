package com.soprasteria.johannesbrodwall.numbers;

import java.util.HashMap;
import java.util.Map;

public class NorwegianNumbers {

    private static Map<Long, String> NUMBERS = new HashMap<>();

    static {
        NUMBERS.put(1L, "en");
        NUMBERS.put(2L, "to");
        NUMBERS.put(3L, "tre");
        NUMBERS.put(4L, "fire");
        NUMBERS.put(5L, "fem");
        NUMBERS.put(6L, "seks");
        NUMBERS.put(7L, "syv");
        NUMBERS.put(8L, "åtte");
        NUMBERS.put(9L, "ni");
        NUMBERS.put(10L, "ti");
        NUMBERS.put(11L, "elleve");
        NUMBERS.put(12L, "tolv");
        NUMBERS.put(20L, "tjue");
        NUMBERS.put(40L, "førti");
        NUMBERS.put(50L, "femti");
        NUMBERS.put(60L, "seksti");
        NUMBERS.put(80L, "åtti");
        NUMBERS.put(90L, "nitti");
        NUMBERS.put(100L, "ett hundre");
        NUMBERS.put(1000L, "ett tusen");
        NUMBERS.put(1000_000L, "en million");
        NUMBERS.put(1000_000_000L, "en milliard");
    }

    public static String toNorwegian(long number) {
        if (NUMBERS.containsKey(number)) {
            return NUMBERS.get(number);
        }
        if (number > 1_000_000_000) {
            return convertBigNumber(number, 1_000_000_000, "milliarder");
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

    private static String convertBigNumber(long number, int bigNumber, String bigNumberName) {
        if (number % bigNumber == 0) {
            return toNorwegian(number / bigNumber) + " " + bigNumberName;
        } else if (number % bigNumber >= 100) {
            return toNorwegian(number - number % bigNumber) + " " + toNorwegian(number % bigNumber);
        } else {
            return toNorwegian(number - number % bigNumber) + " og " + toNorwegian(number % bigNumber);
        }
    }
}
