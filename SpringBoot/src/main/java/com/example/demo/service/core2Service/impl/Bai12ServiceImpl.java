package com.example.demo.service.core2Service.impl;

import com.example.demo.entity.Core2_level2.SanPhamBai12;
import com.example.demo.service.core2Service.Bai12Service;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class Bai12ServiceImpl implements Bai12Service {
    @Override
    public List<SanPhamBai12> sortByName(List<SanPhamBai12> sanPhams) {
        Collections.sort(sanPhams, Comparator.comparing(SanPhamBai12::getName));
        return sanPhams;
    }

    @Override
    public List<SanPhamBai12> sortByPrice(List<SanPhamBai12> sanPhams) {
        Collections.sort(sanPhams, Comparator.comparing(SanPhamBai12::getPrice));
        return sanPhams;
    }

    @Override
    public List<SanPhamBai12> sortByDate(List<SanPhamBai12> sanPhams) {
        Collections.sort(sanPhams, Comparator.comparing(SanPhamBai12::getDate));
        return sanPhams;
    }

    @Override
    public List<SanPhamBai12> sortByPriceAndate(List<SanPhamBai12> sanPhams) {
        Collections.sort(sanPhams, Comparator.comparing(SanPhamBai12::getPrice).thenComparing(SanPhamBai12::getDate));
        return sanPhams;
    }
}
