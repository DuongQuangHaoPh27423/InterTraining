package com.example.demo.controller.core2Controller;

import com.example.demo.service.core2Service.Bai5Service;
import com.example.demo.service.core2Service.impl.Bai5ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/java-spring-2/bai5")
public class Bai5Controller {
    @Autowired
    private Bai5ServiceImpl service;

    @GetMapping
    public ResponseEntity<ArrayList<String>> bai5(@RequestParam("numArray") int[] nums, @RequestParam("target") int target) {
        Map<Integer, Integer> result = service.twoSum(nums, target);
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : result.entrySet()) {
            list.add("[" + i.getKey() + ", " + i.getValue() + "]");
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
