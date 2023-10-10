package com.example.demo.level2;

import java.util.Collections;
import java.util.List;

public class Bai5 {


    public Integer findMax(List<Integer> list) {

//        int maxList = 0;
//        int max = 0;
        if (list == null) {
            System.out.println("khong dc de rỗng");

            return null;
        }
        if (list.isEmpty()) {
            System.out.println("khong dc de trong");
            return list.size();
        }

        Collections.sort(list);
        System.out.println("Max:" + list.get(list.size() - 1));
        return list.get(list.size() - 1);
    }
}

