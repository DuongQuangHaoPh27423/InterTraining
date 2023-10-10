package com.example.demo.level1;

import java.util.List;

public class Bai5 {
    public String findShort(List<String> list) {

        if(list==null){
            System.out.println("không được để rỗng!");
            return null;
        }
        if(list.isEmpty()){
            System.out.println("không được để trống!");
            return "";
        }
        String min = list.get(0);
        for (String str : list) {
            if (str.length() < min.length()) {
                min = str;
                break;
            }
        }
        System.out.printf("Chuoi ngan nhat la:" + min);
        return min;
    }
}
