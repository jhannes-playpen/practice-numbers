package com.soprasteria.johannesbrodwall.numbers;

import java.util.Map;

public class NorwegianNumbers {

    private static Map<Integer, String> numbers = Map.of(1, "en",
            2, "to",
            3, "tre",
            5, "fem",
            9, "ni",
            20, "tjue",
            40, "førti",
            50, "femti",
            100, "ett hundre"
    );

    public static String toNorwegian(int number) {
        if (number > 100) {
            return toNorwegian(number - number % 100) + " og " + toNorwegian(number % 100);
        }
        if (number > 20 && number % 10 != 0) {
            return toNorwegian(number - number % 10) + toNorwegian(number % 10);
        }
        return numbers.get(number);
    }
}
