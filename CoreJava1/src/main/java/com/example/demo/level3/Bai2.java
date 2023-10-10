package com.example.demo.level3;

import java.util.Collections;
import java.util.List;

public class Bai2 {
    public Integer max(List<Integer> list) {


        if (list == null) {
            System.out.println("không được để rỗng");
            return null;
        }
        if (list.isEmpty()) {
            System.out.println("không được để trống");
            return 0;
        }
        if (list.size() < 2) {
            System.out.println("số lượng phần tử không dủ để tính chênh lệch");
            return 0;
        }
        Collections.sort(list);
        Integer maxDiff= list.get(list.size()-1)- list.get(0);
        System.out.println("Chênh lệch lớn nhất giữa hai phần tử bất kỳ trong danh sách là: " + maxDiff);
        return maxDiff;
    }
}
    
