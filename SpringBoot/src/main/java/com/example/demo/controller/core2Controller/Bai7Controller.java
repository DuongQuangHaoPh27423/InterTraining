package com.example.demo.controller.core2Controller;

import com.example.demo.service.core2Service.impl.Bai7ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/java-spring-2/bai7/")
public class Bai7Controller {

    @Autowired
    private Bai7ServiceImpl service;

    @GetMapping("add")
    public ResponseEntity<?> addNew(@RequestParam("name") String name, @RequestParam("diems") List<Double> diems) {
        service.addNew(name, diems);
        return new ResponseEntity<String>("add", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> diemTB(@RequestParam("diems") List<Double> diems) {
        return ResponseEntity.ok(service.tinhDiem(diems));
    }
}
