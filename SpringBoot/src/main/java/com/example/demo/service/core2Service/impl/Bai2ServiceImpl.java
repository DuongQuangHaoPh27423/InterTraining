package com.example.demo.service.core2Service.impl;

import com.example.demo.service.core2Service.Bai2Service;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Bai2ServiceImpl implements Bai2Service {
    private Set<String> nationals = new HashSet<>();

    @Override
    public void add(String national) {
        nationals.add(national);
    }

    @Override
    public String checkExist(String checkNational) {
        boolean check = nationals.contains(checkNational);
        if (check == true) {
          return   "Có tồn tại";
        } else {
            return "không tồn tại";
        }
    }

    @Override
    public void remove(String check) {
        if (nationals.contains(check)) {
            nationals.remove(check);
            System.out.println("Xoá thành công");
        } else {
            System.out.println("xoá không thành công");
        }
    }

    @Override
    public void Sum() {
        System.out.println(nationals.size());
    }
}
