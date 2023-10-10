package com.example.demo.level4;

import java.util.List;

public class Bai10 {
    public static String[] timChuoiTrungLapLonNhat(List<String> list, int k) throws IllegalAccessException {
        if (list == null || list.size() <= 0) {
            throw new IllegalAccessException("Lỗi");
        }
        int doDaiChuoiMax = 0;
        String[] ketQua = new String[2];

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                String chuoi1 = list.get(i);
                String chuoi2 = list.get(j);
                int doDaiTrungLap = tinhDoDaiTrungLap(list.get(i), list.get(j), k);
                if (doDaiTrungLap > doDaiChuoiMax) {
                    doDaiChuoiMax = doDaiTrungLap;
                    ketQua[0] = chuoi1;
                    ketQua[1] = chuoi2;
                }
            }
        }
        System.out.println(ketQua);
        return ketQua;
    }

    private static int tinhDoDaiTrungLap(String chuoi1, String chuoi2, int k) {
        int doDaiTrungLapMax = 0;
        for (int i = 0; i <= chuoi1.length() - k; i++) {
            String doDai1 = chuoi1.substring(i, i + k);
            for (int j = 0; i <= chuoi2.length() - k; j++) {
                String doDai2 = chuoi2.substring(j, i + k);
                if (doDai1.equals(doDai2)) {
                    int doDaiTrungLap = k - i;
                    doDaiTrungLapMax = Math.max(doDaiTrungLapMax, doDaiTrungLap);
                }
            }
        }
        return doDaiTrungLapMax;
    }
}
