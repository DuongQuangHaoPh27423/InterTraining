package com.example.demo.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai10Test {
    private Bai10 bai10 = new Bai10();

    @Test
    void testInput() {
        List<String> listInput = new ArrayList<>(Arrays.asList("Duong", "Quang", "Hao"));
        int expectResult = 2;
        int actualResult = bai10.demSo(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testSo() {
        List<String> listInput = new ArrayList<>(Arrays.asList("Duong123", "Quang", "Hao"));
        int expectResult = 0;
        int actualResult = bai10.demSo(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testIsEmpty() {
        List<String> listInput = new ArrayList<>();
        int expectResult = 0;
        int actualResult = bai10.demSo(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testNull() {
        bai10.demSo(null);
    }

    @Test
    void testInput0() {
        List<String> listInput = new ArrayList<>(Arrays.asList("Duong", "Qung", "Ho"));
        int expectResult = 0;
        int actualResult = bai10.demSo(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
