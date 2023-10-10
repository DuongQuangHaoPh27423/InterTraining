package com.example.demo.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai1 {
    public Integer findSecondMax(List<Integer> list) {
        if (list == null) {
            System.out.println("danh sách đang rỗng");
            return null;
        }
        if (list.isEmpty()) {
            System.out.println("danh sách đang trống");
            return 0;
        }

        if (list.size() < 2 && list.size() > 0) {
            System.out.println("danh sách có một số không thể so sánh");
            return Integer.MIN_VALUE;
        }
        Collections.sort(list, Collections.reverseOrder());
//        Collections.reverseOrder():sxep lớn dến nhỏ
        if (list.get(0) == list.get(1)) {
            System.out.println("danh sách:" + list);
            System.out.println("Số lớn thứ 2 là:" + list.get(2));
            return list.get(2);
        }
        System.out.println("danh sách:" + list);
        System.out.println("Số lớn thứ 2 là:" + list.get(1));
        System.out.println(list.size());
        return list.get(1);
    }
}
