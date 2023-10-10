package com.example.demo.bai13;

import java.util.*;

public class Bai13 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("mời nhập số lượng phần tử: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Mời nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        trungLap(arr);
    }

    static Set<Integer> trungLap(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> setLap = new HashSet<>();

        for (int input : arr) {
            if (!set.add(input)) {
                setLap.add(input);
            }
        }
        if (set.size() <= 2 && set.size() > 0) {
            System.out.println("có 1 phần tử không thể tìm trùng lặp");
            return setLap;
        }
        if (set.isEmpty()) {
            System.out.println("Không được để trống!");
            return set;
        }
        if (setLap.isEmpty()) {
            System.out.println("không có phần tử trùng lặp");
            return setLap;
        }
        System.out.println("Số phần tử trùng lặp: " + setLap);
        return setLap;
    }
}
