package com.example.demo.service.core2Service;

import com.example.demo.entity.Core2_level2.SanPhamBai8;

import java.util.Map;

public interface Bai8Service {
    Map<String, SanPhamBai8> getAll();

    void addNew(String id, SanPhamBai8 sanpham);

    void remove(String id);

    SanPhamBai8 fìndById(String id);

    void update(String id, SanPhamBai8 sanPhamBai8);
}
