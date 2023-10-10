package com.example.demo.service.core2Service.impl;

import com.example.demo.service.core2Service.Bai13Service;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Bai13ServiceImpl implements Bai13Service {
    @Override
    public Set<Integer> trungLap(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> setLap = new HashSet<>();

        for (int input : arr) {
            if (!set.add(input)) {
                setLap.add(input);
            }
        }
        if (set.size() <= 2 && set.size() > 0) {
            System.out.println("có 1 phần tử không thể tìm trùng lặp");
            return setLap;
        }
        if (set.isEmpty()) {
            System.out.println("Không được để trống!");
            return set;
        }
        if (setLap.isEmpty()) {
            System.out.println("không có phần tử trùng lặp");
            return setLap;
        }
        System.out.println("Số phần tử trùng lặp: " + setLap);
        return setLap;
    }
}
