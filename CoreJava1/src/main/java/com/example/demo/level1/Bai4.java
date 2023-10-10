package com.example.demo.level1;

import java.util.List;


public class Bai4 {
    public static double findLargestNumber(List<Double> numbers) {


        if (numbers == null) {
            System.out.println("List không được rỗng");
            return Double.NaN;
        }
        if (numbers.isEmpty()) {
            System.out.println("List không được trống");
            return 0;
        }
        double largest = numbers.get(0);

        for (double num : numbers) {
            if (num > largest) {
                largest = num;
            }
        }
        System.out.println("so lon nhat la:" + largest);
        return largest;
    }
}


