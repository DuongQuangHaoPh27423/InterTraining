package com.example.demo.bai1;

import java.util.ArrayList;
import java.util.Collections;

public class Bai1 {


    public static void main(String[] args) {

        ArrayList<Integer> listInteger = new ArrayList<>();
        int sum = 0;
        int min = 0;
        int max = 0;
        //Add
        listInteger.add(1);
        listInteger.add(3);
        listInteger.add(-2);
        listInteger.add(22);
        listInteger.add(4);
        listInteger.add(5);
        //Xuat
        System.out.println(listInteger);
        //    SUM
        for (int s : listInteger) {
            sum += s;
        }
        System.out.println("sum: " + sum);

        //    max
        System.out.println("Giá trị lớn nhất: " + Collections.max(listInteger));

        //    min
        System.out.println("Giá trị nhỏ nhất: " + Collections.min(listInteger));
        //Remove
        int number = 3;
        listInteger.remove(Integer.valueOf(number));
        System.out.println(listInteger);
        int number1 = 22;
        boolean check = listInteger.contains(Integer.valueOf(number1));
        if (check == true) {
            System.out.println("tồn tại");
        } else {
            System.out.println("không tồn tại");
        }
    }
}
