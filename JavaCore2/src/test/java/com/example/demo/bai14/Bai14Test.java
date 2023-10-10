package com.example.demo.bai14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Bai14Test {

    private Bai14 bai14 = new Bai14();

    @Test
    void testInput() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 4));
        Set<Integer> expect = new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> actual = bai14.find(set1, set2);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    void testInput1() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>(Arrays.asList(5, 6, 4));
        Set<Integer> expect = new HashSet<>();
        Set<Integer> actual = bai14.find(set1, set2);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    void testInput2() {
        Set<Integer> set2 = null;
        Set<Integer> set1 = new HashSet<>(Arrays.asList(5, 6, 4));
        Set<Integer> expect = null;
        Set<Integer> actual = bai14.find(set1, set2);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    void testInput3() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(5, 6, 4));
        Set<Integer> expect = new HashSet<>();
        Set<Integer> actual = bai14.find(set1, set2);
        Assertions.assertEquals(expect, actual);
    }
}
