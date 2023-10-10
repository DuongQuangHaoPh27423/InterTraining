package com.example.demo.level4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bai7 {
    List<String> arrange(List<String> listInput) {
        Collections.sort(listInput, Comparator.comparing((String s) -> s.split(" ").length)
                .reversed()
                .thenComparing(Comparator.comparingInt(String::length).reversed()));
        return listInput;
    }
}
