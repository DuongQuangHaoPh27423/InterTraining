package com.example.demo.service.core2Service.impl;

import com.example.demo.service.core2Service.Bai6Service;
import org.springframework.stereotype.Service;

@Service
public class Bai6ServiceImpl implements Bai6Service {
    @Override
    public int MaxLoiNhan(int[] arr) {
//        Tìm min
        int minMua = arr[0];
        int maxLoiNhuan = 0;
        int loiNhuan;
        for (int i = 1; i < arr.length; i++) {
            minMua = Math.min(minMua, arr[i]);
            loiNhuan = arr[i] - minMua;
//            sau khi tìm được thì so sánh với max để gán giá trị cho max
            maxLoiNhuan = Math.max(loiNhuan, maxLoiNhuan);
        }
        return maxLoiNhuan;
    }
}
