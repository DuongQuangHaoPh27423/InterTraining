package com.example.demo.level4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Bai2Test {
    private Bai2 bai2 = new Bai2();

    @Test
    void testInput1() {
        int[] input = {1, 3, 4, 5};
        int target = 5;
        int expect = 1;
        int actual = bai2.Sum(input, 5);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    void testInput2() {
        int[] input = {-1, 3, 4, 5};
        int target = 5;
        int expect = 1;
        int actual = bai2.Sum(input, 5);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    void testInput3() {
        int[] input = {};
        int target = 0;
        int expect = 0;
        int actual = bai2.Sum(input, 5);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    void testInput4() {
        int[] input = {1, 4};
        int target = 7;
        int expect = 0;
        int actual = bai2.Sum(input, target);
        Assertions.assertEquals(expect, actual);
    }
}
