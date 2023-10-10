package com.example.demo.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai1Test {
    Bai1 bai1 = new Bai1();

    @Test
    void testInput() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(3, 4, 5));
        int expectResult = 4;
        int actualResul = bai1.findSecondMax(listInput);
        Assertions.assertEquals(expectResult, actualResul);
    }


    @Test
    void testOneInput() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(1));

        int expectResult = Integer.MIN_VALUE;
        int actualResult = bai1.findSecondMax(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }


    @Test
    void testInputBangNhau() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        ;
        int expectResult = 1;
        int actualResult = bai1.findSecondMax(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInput2SoGiongNhau() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 2, 3, 19, 19));
        double expectResult = 10;
        double actualResult = bai1.findSecondMax(numbers);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInPutNumberIsEmpty() {
        List<Integer> numbers = new ArrayList<>();
        double expectResult = 0;
        double actualResult = bai1.findSecondMax(numbers);
        Assertions.assertEquals(expectResult, actualResult);

    }
    @Test
    void testNull() {
        bai1.findSecondMax(null);

    }
}
