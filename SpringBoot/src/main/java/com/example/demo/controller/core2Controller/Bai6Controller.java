package com.example.demo.controller.core2Controller;

import com.example.demo.service.core2Service.Bai6Service;
import com.example.demo.service.core2Service.impl.Bai6ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java-spring-2/bai6")
public class Bai6Controller {
    @Autowired
    private Bai6ServiceImpl service;

    @GetMapping()
    public ResponseEntity<?> max(@RequestParam("arr") int[] arr) {
        return ResponseEntity.ok(service.MaxLoiNhan(arr));
    }
}
