package com.soprasteria.johannesbrodwall.numbers;

import java.util.HashMap;
import java.util.Map;

public class NorwegianNumbers {

    private static Map<Integer, String> NUMBERS = new HashMap<>();

    static {
        NUMBERS.put(1, "en");
        NUMBERS.put(2, "to");
        NUMBERS.put(3, "tre");
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
        NUMBERS.put(100, "ett hundre");
        NUMBERS.put(1000, "ett tusen");
    }

    public static String toNorwegian(int number) {
        if (NUMBERS.containsKey(number)) {
            return NUMBERS.get(number);
        }
        if (number > 1000) {
            if (number % 1000 == 0) {
                return toNorwegian(number / 1000) + " tusen";
            } else if (number % 1000 > 100) {
                return toNorwegian(number - number % 1000) + " " + toNorwegian(number % 1000);
            } else {
                return toNorwegian(number - number % 1000) + " og " + toNorwegian(number % 1000);
            }
        }
        if (number > 100) {
            if (number % 100 != 0) {
                return toNorwegian(number - number % 100) + " og " + toNorwegian(number % 100);
            } else {
                return toNorwegian(number / 100) + " hundre";
            }
        }
        if (number > 20 && number % 10 != 0) {
            return toNorwegian(number - number % 10) + toNorwegian(number % 10);
        }
        throw new IllegalArgumentException("Don't know how to deal with " + number);
    }
}
