package com.example.demo.service.core2Service.impl;

import com.example.demo.service.core2Service.Bai7Service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bai7ServiceImpl implements Bai7Service {
    @Override
    public void addNew(String name, List<Double> diems) {
        HashMap<String, List<Double>> diems1 = new HashMap<>();
        for (Map.Entry<String, List<Double>> sv : diems1.entrySet()) {
            name = sv.getKey();
            diems = sv.getValue();
        }
    }

    @Override
    public double tinhDiem(List<Double> diems) {
        double sum = 0;
        double diemTb = 0;
        for (double diem : diems) {
            sum += diem;
        }
        return diemTb = sum / diems.size();

    }
}
