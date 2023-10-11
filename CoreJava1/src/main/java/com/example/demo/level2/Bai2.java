package com.example.demo.level2;

import java.util.List;

public class Bai2 {
    public String findLongWord(List<String> list) {
        if (list == null) {
            return null;
        }
        String longestWord = "";
        for (String word : list
        ) {
            if (word.length() >= longestWord.length())
                longestWord = word;
        }
        System.out.println("Từ dài nhất là:" + longestWord);
        return longestWord;
    }
}
