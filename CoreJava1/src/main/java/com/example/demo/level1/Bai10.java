package com.example.demo.level1;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai10 {
    public Integer demSo(List<String> input) {
        if (input==null) {
            System.out.println("bạn đang để trống!");
            return null;
        }
        Pattern checkSo = Pattern.compile(".*\\d+.*");
        Matcher matcher = checkSo.matcher(input.toString());


        if (matcher.find()) {
            System.out.println("không được nhập số!");
            return 0;
        }
        if (input.isEmpty()) {
            System.out.println("bạn đang để trống!");
            return 0;
        }
        int count = 0;
        for (String str : input) {
            if (str.contains("a")) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("không có ký tự nào cả");
            return 0;
        }
        System.out.println("có " + count + " trong List");
        return count;
    }
}

