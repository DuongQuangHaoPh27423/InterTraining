package com.example.demo.level3;

import java.util.Collections;
import java.util.List;

public class Bai5 {
    public Integer Sum(List<Integer> list) {
        int min = 1;
        if (list == null) {
            System.out.println("không được để rỗng");
            return null;
        }
        if (list.isEmpty()) {
            System.out.println("không được để trống");
            return min;
        }

        Collections.sort(list);
        for (int i : list) {
            if (i <= min) {
                min += i;
            } else {
                System.out.println("Số đó là:" + min);
                break;
            }
        }
        System.out.println("Số đó là:" + min);
        return min;
    }
}
