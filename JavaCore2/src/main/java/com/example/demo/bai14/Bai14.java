package com.example.demo.bai14;

import java.util.HashSet;
import java.util.Set;

public class Bai14 {
    public Set<Integer> find(Set<Integer> set1, Set<Integer> set2) {
        if (set1 == null || set2 == null) {
            System.out.println("không đc rỗng");
            return null;
        }
        Set<Integer> setChung = new HashSet<>(set1);
        setChung.retainAll(set2);//giữ lại phần tử chung của 2 set
        if (set1.isEmpty() || set2.isEmpty()) {
            System.out.println("không được để trống danh sách");
            return setChung;
        }
        return setChung;
    }
}
