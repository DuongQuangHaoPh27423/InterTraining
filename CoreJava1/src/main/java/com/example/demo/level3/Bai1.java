package com.example.demo.level3;

import java.util.Collections;
import java.util.List;

public class Bai1 {

    public Integer findSecondMin(List<Integer> list) {
//sawps xep min->max
        if (list == null) {
            System.out.println("list rỗng!");
            return null;
        }

        if (list.isEmpty()) {
            System.out.println("list trống!");
            return 0;
        }
        if (list.size() < 2 && list.size() > 0) {
            System.out.println("List có 1 giá trị là :" + list.get(0));
            return list.get(0);
        }

        Collections.sort(list);
        if (list.get(0) == list.get(1)) {
            System.out.println("so be thu 2:" + list.get(2));
            return list.get(2);
        }
        System.out.println("List sap xep:" + list);
        System.out.println("So be thu 2 :" + list.get(1));
        return list.get(1);
    }
}
