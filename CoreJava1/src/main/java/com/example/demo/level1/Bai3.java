package com.example.demo.level1;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai3 {
    public double tinhBinhPhuong(String input) {

        Pattern checkChupattern = Pattern.compile(".*[a-zA-Z].*");
        Matcher matcher = checkChupattern.matcher(input);
        Pattern checkKyTuDacBietPattern = Pattern.compile("[!@#$%^&*(),.?\\\":{}|<>]");
        Matcher matcher1 = checkKyTuDacBietPattern.matcher(input);
        Pattern checkKhoangTrangPattern = Pattern.compile("\\s");
        Matcher matcher2= checkKhoangTrangPattern.matcher(input);
        if (matcher.find()) {
            System.out.println("không được nhập chuỗi");
            return 0;
        }
        if (matcher1.find()) {
            System.out.println("không được nhập kí tự đặc biệt");
            return 0;
        }
        if(matcher2.find()){
            System.out.println("không được nhập khoangr trang");
            return 0;
        }
        Double number = Double.parseDouble(input);
        Double ketQua = Math.pow(number, 2);
        System.out.println("Bình Phương:" + ketQua);
        return ketQua;

    }
}
