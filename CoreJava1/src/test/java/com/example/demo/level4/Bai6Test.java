package com.example.demo.level4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai6Test {
    private Bai6 bai6 = new Bai6();

    @Test
    void testInput() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(-10, -5, 0, 1, 2, 3, 4));
        Integer exactResult = 200;
        Integer actualResult = bai6.findThreeMax(listInput);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void testInput1() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(-10, -5, -1, -2, -3, -4));
        Integer exactResult = -6;
        Integer actualResult = bai6.findThreeMax(listInput);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void testInput2() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(10, 5, 1, 2, 3, 4));
        Integer exactResult = 200;
        Integer actualResult = bai6.findThreeMax(listInput);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void testInput3() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(-10, 5, 1, 2, 3, 4));
        Integer exactResult = 60;
        Integer actualResult = bai6.findThreeMax(listInput);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void testIsEmpty() {
        List<Integer> listInput = new ArrayList<>();
        Integer exactResult = 1;
        Integer actualResult = bai6.findThreeMax(listInput);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void testNull() {
        bai6.findThreeMax(null);
    }
}
