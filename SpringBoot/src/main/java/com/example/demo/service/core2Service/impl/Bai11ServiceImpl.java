package com.example.demo.service.core2Service.impl;

import com.example.demo.service.core2Service.Bai11Service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Bai11ServiceImpl implements Bai11Service {
    private static Map<String, String> listDirect = new HashMap<>();

    @Override
    public String addNew(String word, String defini) {
        if (word == null) {
            System.out.println("rỗng!");
            return "err";
        }
        Pattern checkSo = Pattern.compile(".*\\d+.*");
        Matcher matcher = checkSo.matcher(word);
        Matcher matcher1 = checkSo.matcher(defini);
        if (matcher.find() || matcher1.find()) {
            System.out.println("không được nhập số!");
            return "err";
        }
        if (word == "") {
            System.out.println("từ không được để trống!");
            return word;
        } else {
            listDirect.put(word, defini);
            System.out.println(" Thêm thành công từ " + word + "!");
            return word;
        }
    }

    @Override
    public String findWord(String work) {
        String denifi = listDirect.get(work);
        if (listDirect.containsKey(work)) {
            return "Định nghĩa của từ: " + denifi;
        } else {
            return "\nKhông tìm thấy từ cần tra cứu";
        }
    }
}
