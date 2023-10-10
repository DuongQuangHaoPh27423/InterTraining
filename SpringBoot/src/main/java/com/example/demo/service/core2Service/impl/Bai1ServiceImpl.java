package com.example.demo.service.core2Service.impl;

import com.example.demo.service.core2Service.bai1Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class Bai1ServiceImpl implements bai1Service {
    private final ArrayList<Integer> numbers = new ArrayList<>();

    @Override
    public String addElement(int element) {
        numbers.add(element);
        return "add element successfully";
    }

    @Override
    public String sum() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return "Sum: " + sum;
    }

    @Override
    public String maxMin() {
        return "Max: " + Collections.max(numbers) + "; Min: " + Collections.min(numbers);
    }

    @Override
    public String remove(int element) {
        if (numbers.contains(Integer.valueOf(element))) {
            numbers.remove(Integer.valueOf(element));
            return "remove successfully";
        } else {
            return " remove fail";
        }
    }

    @Override
    public String checkElement(int element) {
        if (numbers.contains(Integer.valueOf(element))) {
            return "element exist";
        } else {
            return "element not exist";
        }
    }
}
