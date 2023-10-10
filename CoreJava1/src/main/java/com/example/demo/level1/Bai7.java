package com.example.demo.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai7 {

    public List<String> sapXep(List<String> list) {
        Pattern checkSo = Pattern.compile(".*\\d+.*");
        Matcher matcher = checkSo.matcher(list.toString());
        List<String> listSapXep = new ArrayList<>(list);


        if (matcher.find()) {
            System.out.println("bạn đã nhập số trong list");
            return list;
        }
        if (listSapXep.isEmpty()) {
            System.out.println("List không được để trống!");
            return listSapXep;
        }
        if (listSapXep.size() <= 2 && listSapXep.size() > 0) {
            System.out.println("chuỗi bạn nhập chỉ có một chữ cái");
            return listSapXep;
        }
        Collections.sort(listSapXep);
        System.out.println("sắp xếp theo thứ tự: " + listSapXep);
        return listSapXep;
    }
}
