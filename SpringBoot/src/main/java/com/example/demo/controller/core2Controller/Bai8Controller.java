package com.example.demo.controller.core2Controller;

import com.example.demo.entity.Core2_level2.SanPhamBai8;
import com.example.demo.service.core2Service.impl.Bai8ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/java-spring-2/bai8/")
public class Bai8Controller {
    @Autowired
    private Bai8ServiceImpl service;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> addNew(@RequestParam("id") String id, @RequestBody SanPhamBai8 sanPham) {
        service.addNew(id, sanPham);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @GetMapping("find-bi-Id/{id}")
    public ResponseEntity<?> findByID(@PathVariable("id") String id) {
        service.fìndById(id);
        return new ResponseEntity<String>("remove", HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        service.remove(id);
        return new ResponseEntity<String>("remove", HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody SanPhamBai8 sanPham) {
        service.update(id, sanPham);
        return new ResponseEntity<String>("update", HttpStatus.OK);
    }
}
