package com.example.demo.service.core2Service;

import com.example.demo.entity.Core2_level2.SanPhamBai12;

import java.util.List;

public interface Bai12Service {
    List<SanPhamBai12> sortByName(List<SanPhamBai12> sanPhams);

    List<SanPhamBai12> sortByPrice(List<SanPhamBai12> sanPhams);

    List<SanPhamBai12> sortByDate(List<SanPhamBai12> sanPhams);

    List<SanPhamBai12> sortByPriceAndate(List<SanPhamBai12> sanPhams);
}
