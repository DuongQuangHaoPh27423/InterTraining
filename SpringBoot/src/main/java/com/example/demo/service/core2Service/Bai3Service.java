package com.example.demo.service.core2Service;

import java.util.Map;

public interface Bai3Service {

    Map<String, Integer> getAll();

    void addNew(String name, Integer age);

    void remove(String name);

    void findByName(String name);
}
