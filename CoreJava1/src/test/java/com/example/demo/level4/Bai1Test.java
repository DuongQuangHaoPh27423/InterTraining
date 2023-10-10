package com.example.demo.level4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Bai1Test {
    private Bai1 bai1 = new Bai1();

    @Test
    void testInput() {
        int arr[] = {6, 7, 0, 2, 8, 1, 3, 9, 4, 5};
        int exactResult = 5;
        int actualResult = bai1.count(arr);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void test1Input() {
        int arr[] = {1};
        int exactResult = 0;
        int actualResult = bai1.count(arr);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void testInputKoXep() {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int exactResult = 0;
        int actualResult = bai1.count(arr);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void testIsEmpty() {
        int arr[] = {};
        int exactResult = 0;
        int actualResult = bai1.count(arr);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void testNull() {
        bai1.count(null);
    }
}
