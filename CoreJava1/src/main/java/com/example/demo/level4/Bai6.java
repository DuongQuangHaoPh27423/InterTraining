package com.example.demo.level4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai6 {
    public Integer findThreeMax(List<Integer> list) {
        if (list == null) {
            System.out.println("không được để rỗng");
            return null;
        }
        Collections.sort(list);
        int n = list.size();
        if (n >= 0 && n < 3) {
            System.out.println("không đủ 3 số để tìm tích!");
            return 1;
        }
//        Nguyên Dương
        Integer productMax1 = list.get(n - 1) * list.get(n - 2) * list.get(n - 3);
//        Có số âm
        Integer productMax2 = list.get(0) * list.get(1) * list.get(n - 1);

        Integer productMax = Math.max(productMax1, productMax2);
        System.out.println("Tích 3 số lớn nhất là:" + productMax);
        return productMax;

    }
}
