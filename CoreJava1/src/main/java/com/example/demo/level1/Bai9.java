package com.example.demo.level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai9 {
    public Integer timSoTu(String input) {
        if (input == null) {
            System.out.println("chuỗi rỗng!");
            return null;
        }
        if (input.trim().isEmpty()) {
            System.out.println("không được để trống!");
            return 0;
        }

        // Chia chuỗi thành các từ dựa trên khoảng trắng
        String[] words = input.trim().split("\\s+");

        // Trả về số từ
        System.out.println(" số từ có trong chuỗi là là:" + words.length);
        return words.length;
    }
}
