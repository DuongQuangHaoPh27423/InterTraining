package com.example.demo.controller.core1Controller;

import com.example.demo.service.core1Service.impl.Level2ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/java-spring-1/level2/")
public class CoreLevel2Controller {
    @Autowired
    private Level2ServiceImpl service;

    @GetMapping("bai1")
    public ResponseEntity<?> bai2(@RequestParam("list") List<Integer> list) {
        return ResponseEntity.ok(service.bai1(list));
    }

    @GetMapping("bai2")
    public ResponseEntity<?> bai2(@RequestParam("strings") String[] strings) {
        return ResponseEntity.ok(service.bai2(strings));
    }

    @GetMapping("bai3")
    public ResponseEntity<?> bai3(@RequestParam("chuoi1") String chuoi1, @RequestParam("chuoi2") String chuoi2) {
        return ResponseEntity.ok(service.bai3(chuoi1, chuoi2));
    }


    @GetMapping("bai4")
    public ResponseEntity<?> bai4(@RequestParam("list") List<Integer> list) {
        return ResponseEntity.ok(service.bai4(list));
    }

    @GetMapping("bai5")
    public ResponseEntity<?> bai5(@RequestParam("list") List<Integer> list) {
        return ResponseEntity.ok(service.bai5(list));
    }

}
