package com.example.demo.controller.core1Controller;

import com.example.demo.service.core1Service.impl.Level3ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/java-spring-1/level3/")
public class CoreLevel3Controller {
    @Autowired
    private Level3ServiceImpl service;

    @GetMapping("bai1")
    public ResponseEntity<?> bai1(@RequestParam("list") List<Integer> list) {
        return ResponseEntity.ok(service.bai1(list));
    }

    @GetMapping("bai2")
    public ResponseEntity<?> bai2(@RequestParam("list") List<Integer> list) {
        return ResponseEntity.ok(service.bai2(list));
    }

    @GetMapping("bai3")
    public ResponseEntity<?> bai3(@RequestParam("str1") String str1, @RequestParam("str2") String str2) {
        return ResponseEntity.ok(service.bai3(str1, str2));
    }

    @GetMapping("bai5")
    public ResponseEntity<?> bai5(@RequestParam("list") List<Integer> list) {
        return ResponseEntity.ok(service.bai5(list));
    }

    @GetMapping("bai6")
    public ResponseEntity<?> bai6(@RequestParam("list1") List<Integer> list1, @RequestParam("list2") List<Integer> list2) {
        return ResponseEntity.ok(service.bai6(list1, list2));
    }

    @GetMapping("bai7")
    public ResponseEntity<?> bai6(@RequestParam("input") String input) {
        return ResponseEntity.ok(service.bai7(input));
    }

}
