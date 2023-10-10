package com.example.demo.level1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai2 {
    public Integer nhapChuoi(String str) {
        Pattern checkSo = Pattern.compile(".*\\d+.*");
        Matcher matcher = checkSo.matcher(str);
        Pattern checkKyTuDacBiet = Pattern.compile("[!@#$%^&*(),.?\\\":{}|<>]");
        Matcher matcher1 = checkKyTuDacBiet.matcher(str);
        Pattern checkKhoangTrangPattern = Pattern.compile("\\s");
        Matcher matcher2 = checkKhoangTrangPattern.matcher(str);

        if (str.equals("")) {
            System.out.println(" chuỗi k dc để trống ");
            return 0;
        }

        if (matcher.find()) {
            System.out.println("chuỗi không được chứa số ");
            return 0;
        }
        if (matcher1.find()) {
            System.out.println("chuỗi không được là kí tự đặc biệt ");
            return 0;
        }
        if (matcher2.find()) {
            System.out.println("chuỗi không được nhap khoang  trang ");
            return 0;
        }
        System.out.println("Độ dài chuỗi vừa nhập: " + str.length());
        return str.length();
    }


}


