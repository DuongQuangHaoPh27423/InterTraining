package com.example.demo.bai12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestBai12 {
    private QuanLySanPham quanLySanPham = new QuanLySanPham();
    private List<SanPham> listSanPham = new ArrayList<>();

    @Test
    void testInputSortByName() {
        listSanPham.add(new SanPham("1", "Hào", 5.5, new Date(2003, 2, 2)));
        listSanPham.add(new SanPham("2", "Hiếu", .1, new Date(2003, 3, 2)));
        listSanPham.add(new SanPham("3", "Anh", 5.2, new Date(2003, 4, 2)));
        quanLySanPham.sortByName(listSanPham);
        quanLySanPham.hienThi(listSanPham);
    }

    @Test
    void testInputSortByPrice() {
        listSanPham.add(new SanPham("1", "Hào", 5.5, new Date(2003, 2, 2)));
        listSanPham.add(new SanPham("2", "Hiếu", .1, new Date(2003, 3, 2)));
        listSanPham.add(new SanPham("3", "Anh", 5.2, new Date(2003, 4, 2)));
        quanLySanPham.sortByPrice(listSanPham);
        quanLySanPham.hienThi(listSanPham);
    }

    @Test
    void testInputSortByDate() {
        listSanPham.add(new SanPham("1", "Hào", 5.5, new Date(2003, 2, 2)));
        listSanPham.add(new SanPham("2", "Hiếu", .1, new Date(2003, 3, 2)));
        listSanPham.add(new SanPham("3", "Anh", 5.2, new Date(2003, 4, 2)));
        quanLySanPham.sortByDate(listSanPham);
        quanLySanPham.hienThi(listSanPham);
    }

    @Test
    void testInputSortByPriceAndDate() {
        listSanPham.add(new SanPham("1", "Hào", 5.5, new Date(2003, 2, 2)));
        listSanPham.add(new SanPham("2", "Hiếu", .1, new Date(2003, 3, 2)));
        listSanPham.add(new SanPham("3", "Anh", 5.2, new Date(2003, 4, 2)));
        quanLySanPham.sortByPriceAndate(listSanPham);
        quanLySanPham.hienThi(listSanPham);
    }

    @Test
    void testInput(){
        listSanPham.add(new SanPham("1", "Hào", 5.5, new Date(2003, 2, 2)));
        listSanPham.add(new SanPham("2", "Hiếu", .1, new Date(2003, 3, 2)));
        listSanPham.add(new SanPham("3", "Anh", 5.2, new Date(2003, 4, 2)));
        quanLySanPham.hienThi(listSanPham);
    }

}
