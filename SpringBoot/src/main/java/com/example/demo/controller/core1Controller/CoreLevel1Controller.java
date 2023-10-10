package com.example.demo.controller.core1Controller;

import com.example.demo.service.core1Service.impl.Level1SerivceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/java-spring-1/level1/")
public class CoreLevel1Controller {
    @Autowired
    private Level1SerivceImpl service;

    @GetMapping("bai1")
    public ResponseEntity<?> bai1(@RequestParam("a") double a, @RequestParam("b") double b) {
        return ResponseEntity.ok(service.bai1(a, b));
    }

    @GetMapping("bai2")
    public ResponseEntity<?> bai2(@RequestParam("input") String input) {
        return ResponseEntity.ok(service.bai2(input));
    }

    @GetMapping("bai3")
    public ResponseEntity<?> bai3(@RequestParam("a") double a) {
        return ResponseEntity.ok(service.bai3(a));
    }

    @GetMapping("bai4")
    public ResponseEntity<?> bai4(@RequestParam("numbers") List<Double> numbber) {
        return ResponseEntity.ok(service.bai4(numbber));
    }

    @GetMapping("bai5")
    public ResponseEntity<?> bai5(@RequestParam("list") List<String> list) {
        return ResponseEntity.ok(service.bai5(list));
    }

    @GetMapping("bai6")
    public ResponseEntity<?> bai6(@RequestParam("list") List<Double> list) {
        return ResponseEntity.ok(service.bai6(list));
    }

    @GetMapping("bai7")
    public ResponseEntity<?> bai7(@RequestParam("list") List<String> listM) {
        return ResponseEntity.ok(service.bai7(listM));
    }

    @GetMapping("bai8")
    public ResponseEntity<?> bai8(@RequestParam("nums") int[] nums) {
        return ResponseEntity.ok(service.bai8(nums));
    }

    @GetMapping("bai9")
    public ResponseEntity<?> bai9(@RequestParam("input") String input) {
        return ResponseEntity.ok(service.bai9(input));
    }

    @GetMapping("bai10")
    public ResponseEntity<?> bai10(@RequestParam("input") List<String> input) {
        return ResponseEntity.ok(service.bai10(input));
    }
}
