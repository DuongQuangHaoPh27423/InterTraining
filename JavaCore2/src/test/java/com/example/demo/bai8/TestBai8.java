package com.example.demo.bai8;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestBai8 {
    private QuanLySanPham quanLySanPham = new QuanLySanPham();

    @Test
    void testInput() {
        String id = "1";
        String name = "hao";
        double price = 4.1;
        int quality = 2;
        quanLySanPham.addNew(id, name, price, quality);
    }

    @Test
    void testInputIsEmpty() {
        String id = "";
        String name = "";
        double price = 4.1;
        int quality = 2;
        quanLySanPham.addNew(id, name, price, quality);
    }

    @Test
    void testNull() {
        String id = null;
        String name = "";
        double price = 4.1;
        int quality = 2;
        quanLySanPham.addNew(id, name, price, quality);
    }

    @Test
    void testPriceMin0() {
        String id = "hao";
        String name = "hao";
        double price = 0;
        int quality = 2;
        quanLySanPham.addNew(id, name, price, quality);
    }

    @Test
    void testQualityMin0() {
        String id = "hao";
        String name = "hao";
        double price = 2;
        int quality = 0;
        quanLySanPham.addNew(id, name, price, quality);
    }
}
