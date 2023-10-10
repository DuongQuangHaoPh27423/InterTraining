package com.example.demo.bai13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestBai13 {
    private Bai13 bai13 = new Bai13();

    @Test
    void testInput() {
        int[] arr = {1, 3, 4, 5, 6, 1, 3, 4};
        Set<Integer> expectResult = new HashSet<>(Arrays.asList(1, 3, 4));
        Set<Integer> actualResult = bai13.trungLap(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testInput1() {
        int[] arr = {-1, -3, 4, 5, 6, -1, -3, 4};
        Set<Integer> expectResult = new HashSet<>(Arrays.asList(-1, -3, 4));
        Set<Integer> actualResult = bai13.trungLap(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testInput2() {
        int[] arr = {1,2};
        Set<Integer> expectResult = new HashSet<>();
        Set<Integer> actualResult = bai13.trungLap(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testInput3() {
        int[] arr = {1,2};
        Set<Integer> expectResult = new HashSet<>();
        Set<Integer> actualResult = bai13.trungLap(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testOneInput() {
        int[] arr = {1};
        Set<Integer> expectResult = new HashSet<>();
        Set<Integer> actualResult = bai13.trungLap(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInputKhongLap() {
        int[] arr = {1, 23, 4, 5, 6, 7, 8, 9};
        Set<Integer> expectResult = new HashSet<>();
        Set<Integer> actualResult = bai13.trungLap(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testIsEmpty() {
        int[] arr = {};
        Set<Integer> expectResult = new HashSet<>();
        Set<Integer> actualResult = bai13.trungLap(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
