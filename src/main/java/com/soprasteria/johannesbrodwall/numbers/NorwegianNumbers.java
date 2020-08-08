package com.soprasteria.johannesbrodwall.numbers;

import java.util.HashMap;
import java.util.Map;

public class NorwegianNumbers {

    private static Map<Integer, String> numbers = new HashMap<>();

    static {
        numbers.put(1, "en");
        numbers.put(2, "to");
        numbers.put(3, "tre");
        numbers.put(5, "fem");
        numbers.put(6, "seks");
        numbers.put(8, "åtte");
        numbers.put(9, "ni");
        numbers.put(20, "tjue");
        numbers.put(40, "førti");
        numbers.put(50, "femti");
        numbers.put(60, "seksti");
        numbers.put(100, "ett hundre");
        numbers.put(1000, "ett tusen");
    }

    public static String toNorwegian(int number) {
        if (numbers.containsKey(number)) {
            return numbers.get(number);
        }
        if (number > 100)
            if (number % 100 != 0) {
                return toNorwegian(number - number % 100) + " og " + toNorwegian(number % 100);
            } else {
                return toNorwegian(number/100) + " hundre";
            }
        if (number > 20 && number % 10 != 0) {
            return toNorwegian(number - number % 10) + toNorwegian(number % 10);
        }
        return numbers.get(number);
    }
}
