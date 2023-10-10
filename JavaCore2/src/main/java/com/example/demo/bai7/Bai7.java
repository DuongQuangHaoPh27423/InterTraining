package com.example.demo.bai7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bai7 {

    public static void main(String[] args) {
        HashMap<String, List<Double>> listSinhVien = new HashMap<>();
        listSinhVien.put("Dương Quang Hào", List.of(7.7, 6.7, 8.2, 9.9, 9.1));
        listSinhVien.put("Nguyễn Tuấn Anh", List.of(6.6, 6.7, 7.2, 5.9, 6.1));
        listSinhVien.put("Trần Trung Hiếu", List.of(9.7, 6.7, 3.2, 4.9, 4.1));
        listSinhVien.put("Nguyễn Vũ Học", List.of(8.7, 8.7, 6.2, 7.9, 5.1));
        for (Map.Entry<String, List<Double>> sinhVien : listSinhVien.entrySet()) {
            String name = sinhVien.getKey();
            List<Double> diem = sinhVien.getValue();
            double diemTb = tinhDiem(diem);
            System.out.println(name + " có điểm TB là: " + diemTb);
        }
    }

    public static double tinhDiem(List<Double> diems) {
        double sum = 0;
        double diemTb = 0;

        if (diems == null || diems.isEmpty() ) {
            System.out.println("không được để trống hoặc rỗng danh sách điểm!");
            return 0;
        }
        for (double diem : diems) {
            if (diem <= 0) {
                System.out.println("không được nhập điểm  âm!");
                return 0;
            }
            if(diem>10){
                System.out.println("không được nhập điểm >10!");
                return 0;
            }
        }

        for (double diem : diems) {
            sum += diem;
        }
        return diemTb = sum / diems.size();
    }

}
