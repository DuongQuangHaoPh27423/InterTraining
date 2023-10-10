package com.example.demo.service.core1Service.impl;

import com.example.demo.service.core1Service.Level3Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Level3ServiceImpl implements Level3Service {
    @Override
    public Integer bai1(List<Integer> list) {
        Collections.sort(list);
        return list.get(1);
    }

    @Override
    public Integer bai2(List<Integer> list) {
        Collections.sort(list);
        Integer maxDiff = list.get(list.size() - 1) - list.get(0);
        return maxDiff;
    }

    @Override
    public String bai3(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > maxLength) {
                        maxLength = dp[i + 1][j + 1];
                        endIndex = i + 1;
                    }
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return str1.substring(endIndex - maxLength, endIndex);
    }

    @Override
    public void bai4() {

    }

    @Override
    public Integer bai5(List<Integer> list) {
        int min = 1;
        Collections.sort(list);
        for (int i : list) {
            if (i <= min) {
                min += i;
            }
        }
        System.out.println("Số đó là:" + min);
        return min;
    }

    @Override
    public Double bai6(List<Integer> list1, List<Integer> list2) {
        List<Integer> listChung = new ArrayList<>(list1);
        listChung.addAll(list2);
        Collections.sort(listChung);
        int size = listChung.size();
//        size là chẵn
        if (size % 2 == 0) {
            int so1 = listChung.get(size / 2) - 1;
            int so2 = listChung.get(size / 2);
            int trungVi = (so1 + so2) / 2;
            System.out.println("trung vị là:" + trungVi);
            return Double.valueOf(trungVi);
        } else {
//            size là lẻ
            int trungVi = listChung.get(size / 2);
            System.out.println("trung vị là:" + trungVi);
            return Double.valueOf(trungVi);
        }
    }

    @Override
    public Boolean bai7(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                System.out.println("từ bạn nhập không thể đảo ngược: " + input);
                return false;
            }
            left++;
            right--;
        }
        System.out.println("từ bạn nhập có thể đảo ngược: " + input);
        return true;
    }
}
