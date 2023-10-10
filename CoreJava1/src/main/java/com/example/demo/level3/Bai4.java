package com.example.demo.level3;

import java.util.ArrayList;
import java.util.List;

public class Bai4 {


    public static String[] findLargestOverlap(List<String> strings) {
        if (strings == null || strings.size() < 2)
            throw new IllegalArgumentException("Danh sách phải chứa ít nhất hai chuỗi.");

        int maxOverlap = 0;
        String[] result = new String[2];

        for (int i = 0; i < strings.size(); i++) {
            String str1 = strings.get(i);
            for (int j = i + 1; j < strings.size(); j++) {
                String str2 = strings.get(j);
                int overlap = computeOverlap(str1, str2);
                if (overlap > maxOverlap) {
                    maxOverlap = overlap;
                    result[0] = str1;
                    result[1] = str2;
                }
            }
        }

        return result;
    }

    private static int computeOverlap(String str1, String str2) {
        int maxOverlap = 0;
        int len1 = str1.length();
        int len2 = str2.length();

        // Check for overlap starting from the beginning of str1
        for (int i = 0; i < len1; i++) {
            int overlap = 0;
            for (int j = 0; i + j < len1 && j < len2; j++) {
                if (str1.charAt(i + j) == str2.charAt(j))
                    overlap++;
                else
                    break;
            }
            maxOverlap = Math.max(maxOverlap, overlap);
        }

        return maxOverlap;
    }

}

