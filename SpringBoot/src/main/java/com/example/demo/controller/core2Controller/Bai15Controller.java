package com.example.demo.controller.core2Controller;

import com.example.demo.service.core2Service.impl.Bai15ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/java-spring-2/bai14/")
public class Bai15Controller {
    @Autowired
    private Bai15ServiceImpl service;

    @GetMapping("/min")
    public ResponseEntity<?> min(@RequestParam("set") Set<Integer> set) {
        return ResponseEntity.ok(service.min(set));
    }

    @GetMapping("/max")
    public ResponseEntity<?> max(@RequestParam("set") Set<Integer> set) {
        return ResponseEntity.ok(service.max(set));
    }
}
