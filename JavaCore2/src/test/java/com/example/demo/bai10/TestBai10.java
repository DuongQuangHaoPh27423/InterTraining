package com.example.demo.bai10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestBai10 {
    private Bai10 bai10 = new Bai10();

    @Test
    void testInput() {
        Map<Double, Integer> listInput = new HashMap<>();
        double minScore = 0.0;
        double maxScore = 10.0;
        int expectResult = 0;
        int actualResult = bai10.sapXep(listInput, minScore, maxScore);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testInput1() {
        Map<Double, Integer> listInput = new HashMap<>();
        listInput.put(9.0, 3);
        listInput.put(8.0, 2);
        listInput.put(3.5, 4);
        double minScore = 0.0;
        double maxScore = 10.0;
        int expectResult = 6;
        int actualResult = bai10.sapXep(listInput, minScore, maxScore);
        Assertions.assertEquals(expectResult, actualResult);
    }
    void testInput2() {
        Map<Double, Integer> listInput = new HashMap<>();
        listInput.put(-9.0, 3);
        listInput.put(8.0, 2);
        listInput.put(3.5, 4);
        double minScore = 0.0;
        double maxScore = 10.0;
        int expectResult = 0;
        int actualResult = bai10.sapXep(listInput, minScore, maxScore);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
