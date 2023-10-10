package com.example.demo.controller.core2Controller;

import com.example.demo.service.core2Service.impl.Bai10ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java-spring-2/bai10")
public class Bai10Controller {
    @Autowired
    private Bai10ServiceImpl bai10Service;

    @GetMapping()
    public ResponseEntity<?> count(@RequestParam("score") double score) {
        return ResponseEntity.ok(bai10Service.scoresCount(score));
    }
}
