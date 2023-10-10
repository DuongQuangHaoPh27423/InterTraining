package com.example.demo.controller.core2Controller;

import com.example.demo.service.core2Service.impl.Bai11ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/java-spring-2/bai11/")
public class Bai11Controller {
    @Autowired
    private Bai11ServiceImpl service;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestParam("work") String work,
                                 @RequestParam("denifi") String denifi) {
        return ResponseEntity.ok(service.addNew(work, denifi));
    }

    @GetMapping("add")
    public ResponseEntity<?> find(@RequestParam("work") String work
    ) {
        return ResponseEntity.ok(service.findWord(work));
    }

}
