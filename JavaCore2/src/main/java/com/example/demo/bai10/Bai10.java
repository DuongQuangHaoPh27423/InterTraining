package com.example.demo.bai10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai10 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Mời nhập số lượng sinh viên: ");
        int soLuong = sc.nextInt();
        Map<Double, Integer> list = new HashMap<>();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập điểm sinh viên thứ " + (i + 1) + ":");
            double diem = sc.nextDouble();
//            kiểm tra xem điểm tồn tại chưa
//            rồi thì +1
            if (list.containsKey(diem)) {
                int count = list.get(diem);
                list.put(diem, count + 1);
//                chưa thì default giá trị đầu =1;
            } else {
                list.put(diem, 1);
            }
        }
        int diemCao = sapXep(list, 8.0, 10.0);
        int diemKha = sapXep(list, 5.0, 8.0);
        int diemYeu = sapXep(list, 0, 5);
        System.out.println("Số sinh viên điểm Cao: " + diemCao);
        System.out.println("Số sinh viên điểm Khá: " + diemKha);
        System.out.println("Số sinh viên điểm Yếu: " + diemYeu);
    }

    static int sapXep(Map<Double, Integer> list, double diemMin, double diemMax) {
        int count = 0;
        for (Map.Entry<Double, Integer> entry : list.entrySet()) {
            double diem = entry.getKey();
            if (diem >= 0 && diem <= 10) {
                if (diem <= diemMax && diem > diemMin) {
                    count += entry.getValue();
                }
            } else {
                System.out.println("Điểm>0 và <=10");
                return 0;
            }
        }
        return count;
    }
}
