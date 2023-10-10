package com.example.demo.bai4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bai4 {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>(Arrays.asList(44,22,11,4,1,5,67,122));
        Collections.sort(list);
//        Tăng dần
        System.out.println("list tăng dần:"+list);
//        GIảm dần:dùng reverseOrder
        Collections.sort(list,Collections.reverseOrder());
        System.out.println("List giảm dần:"+list);
    }
}
