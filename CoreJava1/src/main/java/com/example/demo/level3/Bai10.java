package com.example.demo.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bai10 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add("strawberry");
        listSx(list);
        System.out.println(list);
    }

    static List<String> listSx(List<String> listInput) {
        Collections.sort(listInput);
        return listInput;
    }
}
