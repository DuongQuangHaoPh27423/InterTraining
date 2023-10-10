package com.example.demo.bai6;

import java.util.List;

public class Bai6 {
    int MaxLoiNhuan(int[] arr) {
        int minMua = arr[0];
        int maxLoiNhuan = 0;
        int loiNhuan;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= 0) {
                System.out.println(" CP không được âm!");
                return 0;
            }
        }
        if (arr.length < 2) {
            System.out.println("Số lượng CP không hợp lệ!");
            return 0;
        }
//        Tìm min
        for (int i = 1; i < arr.length; i++) {
            minMua = Math.min(minMua, arr[i]);
            loiNhuan = arr[i] - minMua;
//            sau khi tìm được thì so sánh với max để gán giá trị cho max
            maxLoiNhuan = Math.max(loiNhuan, maxLoiNhuan);
        }
        System.out.println("Lợi nhuận tối đa là: " + maxLoiNhuan);
        return maxLoiNhuan;
    }
}
