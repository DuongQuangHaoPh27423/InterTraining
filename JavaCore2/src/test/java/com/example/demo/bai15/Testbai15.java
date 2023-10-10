package com.example.demo.bai15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Testbai15 {
    private Bai15 bai15 = new Bai15();

    @Test
    void testInputMin() {
        Set<Integer> setInput = new HashSet<>(Arrays.asList(22, 11, 4, 2, 1, 6));
        int expectResult = 1;
        int actualResult = bai15.Min(setInput);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testInputMin1() {
        Set<Integer> setInput = new HashSet<>(Arrays.asList(-22,- 11, -4, 2, 1, 6));
        int expectResult = -22;
        int actualResult = bai15.Min(setInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInputMax() {
        Set<Integer> setInput = new HashSet<>(Arrays.asList(22, 11, 4, 2, 1, 6));
        int expectResult = 22;
        int actualResult = bai15.Max(setInput);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testInputMax1() {
        Set<Integer> setInput = new HashSet<>(Arrays.asList(-22, -11, 4, 2, 1, 6));
        int expectResult = 6;
        int actualResult = bai15.Max(setInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testOneInputMin() {
        Set<Integer> setInput = new HashSet<>(Arrays.asList(2));
        int expectResult = 2;
        int actualResult = bai15.Min(setInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testOneInputMax() {
        Set<Integer> setInput = new HashSet<>(Arrays.asList(6));
        int expectResult = 6;
        int actualResult = bai15.Max(setInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInputIsEmptyMin() {
        Set<Integer> setInput = new HashSet<>();
        int expectResult = Integer.MIN_VALUE;
        int actualResult = bai15.Min(setInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInputIsEmptyMax() {
        Set<Integer> setInput = new HashSet<>();
        int expectResult = Integer.MAX_VALUE;
        int actualResult = bai15.Max(setInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testTwoInput() {
        Set<Integer> setInput = new HashSet<>(Arrays.asList(1,3));
        int expectResult = 3;
        int actualResult = bai15.Max(setInput);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testInputBangNhau() {
        Set<Integer> setInput = new HashSet<>(Arrays.asList(1,1,1,1,1,1,1));
        int expectResult = 1;
        int actualResult = bai15.Max(setInput);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
