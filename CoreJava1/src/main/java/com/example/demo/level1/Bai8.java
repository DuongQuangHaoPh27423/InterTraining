package com.example.demo.level1;

import java.util.Arrays;

public class Bai8 {
    public double findMedian(int[] list) {
        // Sắp xếp mảng
        Arrays.sort(list);
        int n = list.length;
        if(n == 0){
            System.out.println("mảng rỗng");
            return Double.NaN;
        }
        if (n % 2 == 0) {
            System.out.println("trung vị là:"+(list[n / 2 - 1] + list[n / 2]) / 2);
            return (double) (list[n / 2 - 1] + list[n / 2]) / 2;
        } else {
            System.out.println("trung vị là:"+ list[n / 2]);

            return (double) list[n / 2];
        }
    }

}
