package com.example.demo.level1;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai1 {

    public int Sum(String number) {
        String[] input = number.split(",");
        Pattern pattern = Pattern.compile(".*[a-zA-Z].*");
        Matcher matcher = pattern.matcher(number);
        Pattern pattern1= Pattern.compile("\\\\d+\\\\.\\\\d+");
        Matcher matcher1 = pattern1.matcher(number);


        if (number.equals("")) {
            System.out.println("trống");
            return 0;
        }
        if (input.length >= 3) {
            System.out.println("bạn nhập lớn hơn 2 só mất rồi!");
            return 0;
        }

        if(matcher1.find()){
            System.out.println("phải là số nguyên!");
            return 0;
        }
        if(!number.equals(matcher) ){
            System.out.println("bạn nhập chữ cái!");
            return 0;
        }

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int sum = a + b;
        return sum;
    }


}
