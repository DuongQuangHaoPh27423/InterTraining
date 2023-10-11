package com.example.demo.level4;

import java.util.Arrays;

public class Bai9 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 3, 7, 6, 4};
        int doDai = doDaiDayConTang(nums);
        System.out.println("Độ dài của dãy con tăng dài nhất: " + doDai);
    }
    public static int doDaiDayConTang(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];  // Tạo một mảng để lưu độ dài của dãy con tại mỗi vị trí
        Arrays.fill(dp, 1);  // Khởi tạo độ dài tối thiểu cho mỗi vị trí là 1 (độ dài tối thiểu là 1, chính là chính nó)

        int doDaiMax = 1;  // Khởi tạo độ dài dãy con tăng dài nhất đã tìm được là 1


        for (int i = 1; i < n; i++) {
            // Duyệt qua các phần tử trước đó để tìm độ dài dãy con tăng tối đa
            for (int j = 0; j < i; j++) {
                // Kiểm tra nếu hiệu tuyệt đối giữa nums[i] và nums[j] không quá 1,
                // và nums[i] lớn hơn nums[j]   
                if (Math.abs(nums[i] - nums[j]) <= 1 && nums[i] > nums[j]) {
                    // Cập nhật độ dài dãy con tại vị trí i
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Cập nhật độ dài dãy con tăng dài nhất đã tìm được
            doDaiMax = Math.max(doDaiMax, dp[i]);
        }

        // Trả về độ dài dãy con tăng dài nhất
        return doDaiMax;
    }

}
