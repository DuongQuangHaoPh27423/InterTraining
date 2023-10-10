package com.example.demo.controller.core2Controller;

import com.example.demo.service.core2Service.impl.Bai13ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java-spring-2/bai13")
public class Bai13Controller {
    @Autowired
    private Bai13ServiceImpl service;

    @GetMapping()
    public ResponseEntity<?> trungLap(@RequestParam("arr") int[] arr) {
        return ResponseEntity.ok(service.trungLap(arr));
    }
}
