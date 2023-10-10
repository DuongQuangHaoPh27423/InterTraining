package com.example.demo.service.Spring2Service.impl;

import com.example.demo.repository.spring2.Level1repository;
import com.example.demo.repository.spring2.Level2Repository;
import com.example.demo.service.Spring2Service.Level1Service;
import com.example.demo.service.Spring2Service.Level2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Lever2ServiceImpl implements Level2Service {
    @Autowired
    private Level2Repository repository;

    @Override
    public List<String> bai1() {
        return repository.bai1();
    }

    @Override
    public List<String> bai2() {
        return repository.bai2();
    }

    @Override
    public List<String> bai3() {
        return repository.bai3();
    }

    @Override
    public List<String> bai4() {
        return repository.bai4();
    }

    @Override
    public List<String> bai5() {
        return null;
    }

    @Override
    public List<String> bai6() {
        return repository.bai6();
    }

    @Override
    public List<String> bai7() {
        return repository.bai7();
    }

    @Override
    public List<String> bai8() {
        return repository.bai8();
    }

    @Override
    public List<String> bai9() {
        return repository.bai9();
    }

    @Override
    public List<String> bai10() {
        return repository.bai10();
    }
}
