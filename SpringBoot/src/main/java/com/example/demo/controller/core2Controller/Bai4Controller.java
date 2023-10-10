package com.example.demo.controller.core2Controller;

import com.example.demo.service.core2Service.impl.Bai4ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java-spring-2/bai4/")
public class Bai4Controller {
    @Autowired
    private Bai4ServiceImpl service;

    @GetMapping()
    public ResponseEntity<?> getAll() {

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("add")
    public ResponseEntity<?> addNew(@RequestParam("a") Integer a) {
        service.addNew(a);
        return new ResponseEntity<String>("add", HttpStatus.OK);
    }

    @GetMapping("sap-xep-tang-dan")
    public ResponseEntity<?> arrTang() {
        return new ResponseEntity<>(service.arrangeSortUp(), HttpStatus.OK);
    }

    @GetMapping("sap-xep-giam-dan")
    public ResponseEntity<?> arrGiam() {
        return new ResponseEntity<>(service.arrangeSortDown(), HttpStatus.OK);
    }

}
