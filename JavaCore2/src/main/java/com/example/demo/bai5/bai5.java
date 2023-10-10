package com.example.demo.bai5;

import java.util.HashMap;
import java.util.Map;

public class bai5 {
    int[] find(int[] arr, Integer target) {
//        dùng map vì sẽ không bị lặp phần tử
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int a = target - arr[i];
            if (map.containsKey(a)) {
                int[] result = {map.get(a), i};
                return result;
            }
            map.put(arr[i], i);
        }
        throw new IllegalArgumentException("Không có số nào");
    }
}
