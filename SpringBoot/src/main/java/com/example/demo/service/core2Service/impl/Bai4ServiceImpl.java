package com.example.demo.service.core2Service.impl;

import com.example.demo.service.core2Service.Bai4Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Bai4ServiceImpl implements Bai4Service {
    private List<Integer> list = new ArrayList<>();

    @Override
    public List<Integer> getAll() {
        return list;
    }

    @Override
    public void addNew(int a) {
        list.add(a);
    }

    @Override
    public String arrangeSortUp() {
        Collections.sort(list);

        return "list: " + list;
    }

    @Override
    public String arrangeSortDown() {
        Collections.sort(list, Collections.reverseOrder());

        return "list: " + list;
    }

}
