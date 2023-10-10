package com.example.demo.service.Spring2Service.impl;

import com.example.demo.repository.spring2.Level4Repository;
import com.example.demo.service.Spring2Service.Level4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Level4ServiceImpl implements Level4Service {
    @Autowired
    private Level4Repository repository;

    @Override
    public void bai1() {
        repository.bai1();
    }

    @Override
    public void bai2() {
        repository.bai2();
    }

    @Override
    public void bai3() {
        repository.bai3();
    }

    @Override
    public void bai4() {
        repository.bai4();
    }

    @Override
    public void bai5() {
        repository.bai5();
    }

    @Override
    public void bai6() {
        repository.bai6();
    }

    @Override
    public void bai7() {
        repository.bai7();
    }

    @Override
    public void bai8() {
        repository.bai8();
    }

    @Override
    public void bai9() {
        repository.bai9();
    }

    @Override
    public void bai910() {
        repository.bai10();
    }
}
