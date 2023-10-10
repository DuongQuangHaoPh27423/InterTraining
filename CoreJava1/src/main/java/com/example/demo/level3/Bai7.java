package com.example.demo.level3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai7 {
    public Boolean daoNguoc(String input) {

        if (input == null) {
            System.out.println("không được để rỗng");
            return null;
        }
        //        replaceAll: thay thế khoảng trắng thành ""
//        toLowerCAse: viết hoa-> thường
        input = input.replaceAll("\\s+", "").toLowerCase();
        Pattern pattern = Pattern.compile("[!@#$%^&*(),.?\\\":{}|<>]");
        Matcher matcher = pattern.matcher(input);
        int left = 0;
        int right = input.length() - 1;

        if (input.isEmpty()) {
            System.out.println("không được để trống");
            return false;
        }
        if (matcher.find()) {
            System.out.println("bạn đã nhập kí tự đặc biệt");
            return false;
        }
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                System.out.println("từ bạn nhập không thể đảo ngược: " + input);
                return false;
            }
            left++;
            right--;
        }
        System.out.println("từ bạn nhập có thể đảo ngược: " + input);
        return true;
    }
}
