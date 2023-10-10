package com.example.demo.level4;

import java.util.HashSet;
import java.util.Set;

public class Bai2 {

    public int Sum(int[] nums, int target) {
        int count = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int num : nums
        ) {
            sum += num;

            if (set.contains(sum - target))
                count++;
            set.add(sum);
        }
        return count;
    }
}
