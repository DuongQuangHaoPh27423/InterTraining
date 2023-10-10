package com.example.demo.controller.Spring2Controller;

import com.example.demo.service.Spring2Service.Level2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sql/level2/")
public class Level2Controller {
    @Autowired
    private Level2Service service;

    @GetMapping("/bai1")
    public ResponseEntity<?> bai1() {
        return ResponseEntity.ok(service.bai1());
    }

    @GetMapping("/bai2")
    public ResponseEntity<?> bai2() {
        return ResponseEntity.ok(service.bai2());
    }

    @GetMapping("/bai3")
    public ResponseEntity<?> bai3() {
        return ResponseEntity.ok(service.bai3());
    }

    @GetMapping("/bai4")
    public ResponseEntity<?> bai4() {
        return ResponseEntity.ok(service.bai4());
    }

    @GetMapping("/bai5")
    public ResponseEntity<?> bai5() {
        return ResponseEntity.ok(service.bai5());
    }

    @GetMapping("/bai6")
    public ResponseEntity<?> bai6() {
        return ResponseEntity.ok(service.bai6());
    }

    @GetMapping("/bai7")
    public ResponseEntity<?> bai7() {
        return ResponseEntity.ok(service.bai7());
    }

    @GetMapping("/bai8")
    public ResponseEntity<?> bai8() {
        return ResponseEntity.ok(service.bai8());
    }

    @GetMapping("/bai9")
    public ResponseEntity<?> bai9() {
        return ResponseEntity.ok(service.bai8());
    }

    @GetMapping("/bai10")
    public ResponseEntity<?> bai10() {
        return ResponseEntity.ok(service.bai8());
    }
}
