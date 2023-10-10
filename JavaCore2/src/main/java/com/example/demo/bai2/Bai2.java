package com.example.demo.bai2;

import java.util.HashSet;
import java.util.Set;

public class Bai2 {
    public static void main(String[] args) {
        Set<String> nationals = new HashSet<>();
//        ADD
        nationals.add("Việt Nam");
        nationals.add("Thái Lan");
        nationals.add("Trung Quốc");
        nationals.add("Mỹ");
        nationals.add("Hàn Quốc");
//        XUAT
        System.out.println(nationals);
//        Check exist
        String checkExist = "Mỹ";
        boolean check = nationals.contains(checkExist);
        if (check == true) {
            System.out.println("Có tồn tại");
        } else {
            System.out.println("không tồn tại");
        }
//        check Remove
        String checkRemove = "Trung Quốc";
        nationals.remove(checkRemove);
        System.out.println(nationals);
//check SUm
        System.out.println(nationals.size());
    }

}
