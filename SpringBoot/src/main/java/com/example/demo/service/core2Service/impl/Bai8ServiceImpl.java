package com.example.demo.service.core2Service.impl;

import com.example.demo.entity.Core2_level2.SanPhamBai8;
import com.example.demo.service.core2Service.Bai8Service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Bai8ServiceImpl implements Bai8Service {
    private HashMap<String, SanPhamBai8> map = new HashMap<>();

    @Override
    public Map<String, SanPhamBai8> getAll() {
        return map;
    }

    @Override
    public void addNew(String id, SanPhamBai8 sanpham) {
        if (map.containsKey(id)) {
            System.out.println("san pham dâ ton tai!");
        } else {
            map.put(id, sanpham);
            System.out.println("them thanh cong!");
        }
    }

    @Override
    public void remove(String id) {
        if (map.containsKey(id)) {
            map.remove(id);
            System.out.println("xoa thanh cong");
        } else {
            System.out.println("san pham khong ton tai");
        }
    }

    @Override
    public SanPhamBai8 fìndById(String id) {
        if (map.containsKey(id)) {
            SanPhamBai8 sanPhamBai8 = map.get(id);
            return sanPhamBai8;
        } else
            return null;
    }

    @Override
    public void update(String id, SanPhamBai8 sanPhamBai8) {
        if (map.containsKey(id)) {
            SanPhamBai8 sanPham = map.get(id);
            sanPham.setName(sanPham.getName());
            sanPham.setPrice(sanPham.getPrice());
            sanPham.setQuality(sanPham.getQuality());
            System.out.println("them thanh cong!");
        } else {
            System.out.println("san pham khong ton tai");
        }
    }
}
