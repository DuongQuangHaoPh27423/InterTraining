package com.example.demo.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai6 {

    public List<Double> sapXep(List<Double> list) {


        List<Double> sapXep = new ArrayList<>(list);
        if (sapXep.size() < 2 && sapXep.size() > 0) {
            System.out.println("chuỗi có 1 giá trị nên không sắp xếp:" + list);
            return list;
        }
        if (sapXep.isEmpty()) {
            System.out.println("không được để trống");
            return list;
        }
        Collections.sort(sapXep);

        System.out.println("Chuỗi sau khi được sắp xếp là: " + sapXep);
        return sapXep;

    }
}
