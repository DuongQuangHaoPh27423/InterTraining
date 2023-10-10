package com.example.demo.level2;

import java.util.List;

public class Bai3 {

    public static String[] timChuoiTrungLapLonNhat(List<String> list) {
        int doDaiChuoiMax = 0;
        String[] ketQua = new String[2];

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int doDaiTrungLap = tinhDoDaiTrungLap(list.get(i), list.get(j));
                if (doDaiTrungLap > doDaiChuoiMax) {
                    doDaiChuoiMax = doDaiTrungLap;
                    ketQua[0] = list.get(i);
                    ketQua[1] = list.get(j);
                }
            }
        }
        System.out.println(ketQua);
        return ketQua;
    }

    private static int tinhDoDaiTrungLap(String chuoi1, String chuoi2) {
        int doDaiTrungLapMax = 0;
        int doDai1 = chuoi1.length();
        int doDai2 = chuoi2.length();

        for (int i = 1; i <= Math.min(doDai1, doDai2); i++) {
            if (chuoi1.substring(doDai1 - i).equals(chuoi2.substring(0, i))) {
                doDaiTrungLapMax = i;
            }
        }
        return doDaiTrungLapMax;
    }
}


