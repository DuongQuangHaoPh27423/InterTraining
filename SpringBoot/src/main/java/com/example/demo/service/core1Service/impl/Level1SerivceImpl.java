package com.example.demo.service.core1Service.impl;

import com.example.demo.service.core1Service.Level1Service;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class Level1SerivceImpl implements Level1Service {
    @Override
    public double bai1(double a, double b) {
        return a + b;
    }

    @Override
    public int bai2(String str) {
        return str.length();
    }

    @Override
    public double bai3(double a) {
        return a * a;
    }

    @Override
    public double bai4(List<Double> numbers) {
        Collections.sort(numbers);
        return numbers.get(numbers.size());
    }

    @Override
    public String bai5(List<String> list) {
        String min = list.get(0);
        for (String str : list) {
            if (str.length() < min.length()) {
                min = str;
                break;
            }
        }
        return min;
    }

    @Override
    public List<Double> bai6(List<Double> list) {
        Collections.sort(list);
        return list;
    }

    @Override
    public List<String> bai7(List<String> list) {
        Collections.sort(list);
        return list;
    }

    @Override
    public double bai8(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n % 2 == 0) {
            System.out.println("trung vị là:" + (nums[n / 2 - 1] + nums[n / 2]) / 2);
            return (double) (nums[n / 2 - 1] + nums[n / 2]) / 2;
        } else {
            System.out.println("trung vị là:" + nums[n / 2]);

            return nums[n / 2];
        }
    }

    @Override
    public Integer bai9(String input) {
        // Chia chuỗi thành các từ dựa trên khoảng trắng
        String[] words = input.trim().split("\\s+");

        // Trả về số từ
        System.out.println(" số từ có trong chuỗi là là:" + words.length);
        return words.length;
    }

    @Override
    public Integer bai10(List<String> input) {
        int count = 0;
        for (String str : input) {
            if (str.contains("a")) {
                count++;
            }
        }
        return count;
    }


}
