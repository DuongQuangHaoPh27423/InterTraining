package com.example.demo.controller.core2Controller;


import com.example.demo.service.core2Service.impl.Bai1ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/java-spring-2/bai1")
public class Bai1Controller {
    @Autowired
    private Bai1ServiceImpl service;

    @GetMapping("/add")
    public ResponseEntity<?> addList(@RequestParam("number") int number) {
        return new ResponseEntity<>(service.addElement(number), HttpStatus.OK);
    }

    @GetMapping("/sum")
    public ResponseEntity<?> sum() {
        return new ResponseEntity<>(service.sum(), HttpStatus.OK);
    }

    @GetMapping("/remove")
    public ResponseEntity<String> removeElement(@RequestParam("element") int number) {
        return new ResponseEntity<>(service.remove(number), HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<String> checjkElement(@RequestParam("element") int number) {
        return new ResponseEntity<>(service.checkElement(number), HttpStatus.OK);
    }

}
