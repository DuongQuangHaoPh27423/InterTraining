package com.example.demo.controller.core2Controller;

import com.example.demo.service.core2Service.impl.Bai9ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java-spring-2/bai9/")
public class Bai9Controller {
    @Autowired
    private Bai9ServiceImpl service;

    @GetMapping
    public ResponseEntity<?> bai9(@RequestParam("text") String text) {
        return ResponseEntity.ok(service.countWords(text));
    }
}
