package com.example.demo.controller.core2Controller;

import com.example.demo.entity.Core2_level2.SanPhamBai12;
import com.example.demo.service.core2Service.impl.Bai12ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/java-spring-2/bai12/")
public class Bai12Controller {
    @Autowired
    private Bai12ServiceImpl service;

    @GetMapping("sort-by-name")
    public ResponseEntity<?> sortByName(@RequestParam("sanPhams") List<SanPhamBai12> sanPhams) {
        return ResponseEntity.ok(service.sortByName(sanPhams));
    }

    @GetMapping("sort-by-price")
    public ResponseEntity<?> sortByPrice(@RequestParam("sanPhams") List<SanPhamBai12> sanPhams) {
        return ResponseEntity.ok(service.sortByPrice(sanPhams));
    }

    @GetMapping("sort-by-date")
    public ResponseEntity<?> sortByDate(@RequestParam("sanPhams") List<SanPhamBai12> sanPhams) {
        return ResponseEntity.ok(service.sortByDate(sanPhams));
    }

    @GetMapping("sort-by-price-date")
    public ResponseEntity<?> sortByPriceAndDate(@RequestParam("sanPhams") List<SanPhamBai12> sanPhams) {
        return ResponseEntity.ok(service.sortByPriceAndate(sanPhams));
    }

}
