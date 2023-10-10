package com.example.demo.service.core2Service.impl;

import com.example.demo.service.core2Service.Bai15Serivce;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class Bai15ServiceImpl implements Bai15Serivce {
    @Override
    public Integer min(Set<Integer> set) {
        if (set.isEmpty()) {
            System.out.println("Không được để trống!");
            return Integer.MIN_VALUE;
        }
        int min = Collections.min(set);
        System.out.println("Min:" + min);
        return min;
    }

    @Override
    public Integer max(Set<Integer> set) {
        if (set.isEmpty()) {
            System.out.println("Không được để trống!");
            return Integer.MAX_VALUE;
        }
        int max = Collections.max(set);
        System.out.println("Max: " + max);
        return max;
    }
}
