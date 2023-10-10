package com.example.demo.bai11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestBai11 {
    private Bai11 bai11 = new Bai11();

    @Test
    void TestInput() {
        String expectResult = "hao";
        String actualyResult = bai11.addNew("hao", "haone");
        Assertions.assertEquals(expectResult, actualyResult);
    }

    @Test
    void TestInputIsEmpty() {
        String expectResult = "";
        String actualyResult = bai11.addNew("", "haone");
        Assertions.assertEquals(expectResult, actualyResult);
    }

    @Test
    void TestInputNull() {
        bai11.addNew(null, "haone");
    }

    @Test
    void inPutNumber() {
        String expectResult = "err";
        String actualyResult = bai11.addNew("hao123", "haone");
        Assertions.assertEquals(expectResult, actualyResult);
    }
    @Test
    void inPutNumbe1r() {
        String expectResult = "err";
        String actualyResult = bai11.addNew("hao", "haone123");
        Assertions.assertEquals(expectResult, actualyResult);
    }
}
