package com.example.demo.service.core2Service.impl;

import com.example.demo.service.core2Service.Bai3Service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Bai3ServiceImpl implements Bai3Service {
    private Map<String, Integer> map = new HashMap<>();

    @Override
    public Map<String, Integer> getAll() {
        return map;
    }

    @Override
    public void addNew(String name, Integer age) {
        map.put(name, age);
    }

    @Override
    public void remove(String name) {
        map.remove(name);
    }

    @Override
    public void findByName(String name) {
        map.containsKey(name);
    }
}
