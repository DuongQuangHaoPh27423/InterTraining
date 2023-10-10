package com.example.demo.controller.Spring2Controller;

import com.example.demo.service.Spring2Service.impl.Level4ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sql/level-4/")
public class Level4Controller {
    @Autowired
    private Level4ServiceImpl service;

    @GetMapping("bai1")
    public ResponseEntity<?> bai1() {
        service.bai1();
        return new ResponseEntity<String>("Update thanhf cong!", HttpStatus.OK);
    }

    @GetMapping("bai2")
    public ResponseEntity<?> bai2() {
        service.bai2();
        return new ResponseEntity<String>("Update thanhf cong!", HttpStatus.OK);
    }

    @GetMapping("bai3")
    public ResponseEntity<?> bai3() {
        service.bai3();
        return new ResponseEntity<String>("Update thanhf cong!", HttpStatus.OK);
    }

    @GetMapping("bai4")
    public ResponseEntity<?> bai4() {
        service.bai4();
        return new ResponseEntity<String>("Update thanhf cong!", HttpStatus.OK);
    }

    @GetMapping("bai5")
    public ResponseEntity<?> bai5() {
        service.bai5();
        return new ResponseEntity<String>("Update thanhf cong!", HttpStatus.OK);
    }

    @GetMapping("bai6")
    public ResponseEntity<?> bai6() {
        service.bai6();
        return new ResponseEntity<String>("Update thanhf cong!", HttpStatus.OK);
    }

    @GetMapping("bai7")
    public ResponseEntity<?> bai7() {
        service.bai7();
        return new ResponseEntity<String>("Update thanhf cong!", HttpStatus.OK);
    }

    @GetMapping("bai8")
    public ResponseEntity<?> bai8() {
        service.bai8();
        return new ResponseEntity<String>("Update thanhf cong!", HttpStatus.OK);
    }

    @GetMapping("bai9")
    public ResponseEntity<?> bai9() {
        service.bai9();
        return new ResponseEntity<String>("Update thanhf cong!", HttpStatus.OK);
    }

    @GetMapping("bai10")
    public ResponseEntity<?> bai10() {
        service.bai910();
        return new ResponseEntity<String>("Update thanhf cong!", HttpStatus.OK);
    }
}
