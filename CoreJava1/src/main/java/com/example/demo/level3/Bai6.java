package com.example.demo.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai6 {
    public Double timTrungVi(List<Integer> list1, List<Integer> list2) {
        if (list1 == null && list2 == null) {
            System.out.println(" dach sách rỗng không tính được! ");
            return null;
        }
        if (list1.isEmpty() && list2.isEmpty()) {
            System.out.println("hai danh sách đều trống không tính được!");
            return 0.0;
        }

        List<Integer> listChung = new ArrayList<>(list1);
        listChung.addAll(list2);
        Collections.sort(listChung);
        int size = listChung.size();
//        size là chẵn
        if (size % 2 == 0) {
            int so1 = listChung.get(size / 2) - 1;
            int so2 = listChung.get(size / 2);
            int trungVi = (so1 + so2) / 2;
            System.out.println("trung vị là:" + trungVi);
            return Double.valueOf(trungVi);
        } else {
//            size là lẻ
            int trungVi = listChung.get(size / 2);
            System.out.println("trung vị là:" + trungVi);
            return Double.valueOf(trungVi);
        }
    }
}
