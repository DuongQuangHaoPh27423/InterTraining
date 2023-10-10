package com.example.demo.controller.core2Controller;

import com.example.demo.service.core2Service.impl.Bai2ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java-spring-2/bai2/")
public class Bai2Controller {
    @Autowired
    private Bai2ServiceImpl service;

    @GetMapping("/add")
    public ResponseEntity add(@RequestParam("national") String national) {
        service.add(national);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @GetMapping("/check-exist")
    public ResponseEntity<?> checkExist(@RequestParam("national") String check) {
        service.checkExist(check);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @GetMapping("/remove")
    public ResponseEntity<?> remove(@RequestParam("check") String check) {
        service.remove(check);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @GetMapping("/sum")
    public ResponseEntity<?> sum() {
        service.Sum();
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }
}
