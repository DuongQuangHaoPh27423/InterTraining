package com.example.demo.bai15;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bai15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        System.out.println("Mời Nhập số lượng phần tử:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Mời nhập phần tử thứ: " + (i + 1));
            int input = sc.nextInt();
            set.add(input);
        }
    }


    static Integer Min(Set<Integer> set) {
        if (set.isEmpty()) {
            System.out.println("Không được để trống!");
            return Integer.MIN_VALUE;
        }
        int min = Collections.min(set);
        System.out.println("Min:" + min);
        return min;
    }

    static Integer Max(Set<Integer> set) {
        if (set.isEmpty()) {
            System.out.println("Không được để trống!");
            return Integer.MAX_VALUE;
        }
        int max = Collections.max(set);
        System.out.println("Max: " + max);
        return max;
    }

}
