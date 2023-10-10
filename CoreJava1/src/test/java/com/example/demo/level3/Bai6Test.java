package com.example.demo.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai6Test {
    private Bai6 bai6 = new Bai6();

    @Test
    void testInputChan() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 4, 6));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(8, 10, 12));
        double exactReSult = 7;
        double actualResult = bai6.timTrungVi(list1, list2);
        Assertions.assertEquals(exactReSult, actualResult);
    }


    @Test
    void testInputLe() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(7, 9));
        double exactReSult = 5;
        double actualResult = bai6.timTrungVi(list1, list2);
        Assertions.assertEquals(exactReSult, actualResult);
    }

    @Test
    void testInputList1Empty() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>(Arrays.asList(7, 9));
        double exactReSult = 8;
        double actualResult = bai6.timTrungVi(list1, list2);
        Assertions.assertEquals(exactReSult, actualResult);
    }

    @Test
    void testInputList2Empty() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> list2 = new ArrayList<>();
        double exactReSult = 2;
        double actualResult = bai6.timTrungVi(list1, list2);
        Assertions.assertEquals(exactReSult, actualResult);
    }

    @Test
    void testInputIsEmpty() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        double exactReSult = 0;
        double actualResult = bai6.timTrungVi(list1, list2);
        Assertions.assertEquals(exactReSult, actualResult);
    }

    @Test
    void testNull() {
        bai6.timTrungVi(null, null);
    }
}
