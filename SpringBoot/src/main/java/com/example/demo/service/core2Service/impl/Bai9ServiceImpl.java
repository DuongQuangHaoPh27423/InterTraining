package com.example.demo.service.core2Service.impl;

import com.example.demo.service.core2Service.Bai9Service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class Bai9ServiceImpl implements Bai9Service {
    @Override
    public Map<String, Integer> countWords(String text) {
        if (text == null) {
            System.out.println("không được để null!");
            return null;
        }
        Map<String, Integer> map = new HashMap<>();

        if (text == "") {
            System.out.println("không được để trống!");
            return map;
        }
        // Xóa các ký tự không phải là chữ cái hoặc khoảng trắng
        text = text.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();

        // Tách văn bản thành các từ
        String[] words = text.split("\\s+");

        // Đếm số lần xuất hiện của từng từ
        for (String word : words) {
//             getOrDefault()  trả về phần tử key được chỉ định
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
        return map;
    }
}
