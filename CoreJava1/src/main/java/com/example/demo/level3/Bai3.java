package com.example.demo.level3;

import java.util.ArrayList;
import java.util.List;

public class Bai3 {


    public static String[] findLargestOverlap(List<String> strings) {
        int max = 0;
        String[] result = new String[2];

        for (int i = 0; i < strings.size(); i++) {
            for (int j = i + 1; j < strings.size(); j++) {
                int overlap = calculateOverlap(strings.get(i), strings.get(j));
                if (overlap > max) {
                    max = overlap;
                    result[0] = strings.get(i);
                    result[1] = strings.get(j);
                }
            }
        }

        return result;
    }

    private static int calculateOverlap(String str1, String str2) {
        int max = 0;
        int len1 = str1.length();
        int len2 = str2.length();

        for (int i = 1; i <= Math.min(len1, len2); i++) {
            if (str1.substring(len1 - i).equals(str2.substring(0, i))) {
                max = i;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("lorem");
        strings.add("world");
        strings.add("laboratory");
        strings.add("rat");
        strings.add("or");

        String[] largestOverlapStrings = findLargestOverlap(strings);
        System.out.println("Strings with the largest overlap: " + largestOverlapStrings[0] + ", " + largestOverlapStrings[1]);
    }
}


