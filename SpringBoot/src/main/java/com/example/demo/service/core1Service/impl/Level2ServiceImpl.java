package com.example.demo.service.core1Service.impl;

import com.example.demo.service.core1Service.Level2Service;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class Level2ServiceImpl implements Level2Service {
    @Override
    public Integer bai1(List<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
        return list.get(1);
    }

    @Override
    public String bai2(String[] strings) {
        int strMax = strings[0].length();
        int index = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strMax < strings[i].length()) {
                strMax = strings[i].length();
                index = i;
            }
        }
        return strings[index];
    }

    @Override
    public int bai3(String chuoi1, String chuoi2) {
        int doDaiTrungLapMax = 0;
        int doDai1 = chuoi1.length();
        int doDai2 = chuoi2.length();

        for (int i = 1; i <= Math.min(doDai1, doDai2); i++) {
            if (chuoi1.substring(doDai1 - i).equals(chuoi2.substring(0, i))) {
                doDaiTrungLapMax = i;
            }
        }
        return doDaiTrungLapMax;
    }


    @Override
    public Integer bai4(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 3 == 0 && list.get(i) % 5 == 0) {
                sum += list.get(i);
            }
        }
        return sum;
    }

    @Override
    public Integer bai5(List<Integer> list) {
        Collections.sort(list);
        System.out.println("Max:" + list.get(list.size() - 1));
        return list.get(list.size() - 1);
    }
}
