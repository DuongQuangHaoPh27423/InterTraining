package com.example.demo.level4;

public class Bai3 {
    public static int Long(String[] strings) {
        if (strings.length == 1)
            return 0;
        if (strings == null || strings.length == 0)
            return 0;

        int maxCommonLength = 0;
        String firstString = strings[0];

        for (int i = 0; i < firstString.length(); i++) {
            for (int j = i + 1; j <= firstString.length(); j++) {
                String substring = firstString.substring(i, j);
                boolean check = true;

                for (int k = 1; k < strings.length; k++) {
                    if (!strings[k].contains(substring)) {
                        check = false;
                        break;
                    }
                }

                if (check && substring.length() > maxCommonLength) {
                    maxCommonLength = substring.length();
                }
            }
        }

        return maxCommonLength;
    }
}
