package com.example.demo.level2;

public class Bai3 {

    public static String timChuoiTrungLapLonNhat(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        int doDaiMax = 0;
        int endIndex = 0;

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > doDaiMax) {
                        doDaiMax = dp[i + 1][j + 1];
                        endIndex = i + 1;
                    }
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return a.substring(endIndex - doDaiMax, endIndex);
    }
}


