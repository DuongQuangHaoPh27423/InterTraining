package com.example.demo.controller.core2Controller;


import com.example.demo.service.core2Service.Bai3Service;
import com.example.demo.service.core2Service.impl.Bai3ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java-spring-2/bai3/")
public class Bai3Controller {
    @Autowired
    private Bai3ServiceImpl service;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("add")
    public ResponseEntity<?> addNew(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        service.addNew(name, age);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @GetMapping("remove")
    public ResponseEntity<?> remove(@RequestParam("name") String name) {
        service.remove(name);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @GetMapping("find-by-name")
    public ResponseEntity<?> findByName(@RequestParam("name") String name) {
        service.findByName(name);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

}
