package com.example.demo.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai2Test {
    private Bai2 bai2 = new Bai2();

    @Test
    void testInput() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(1, -1, 4, 5, 6, 10));
        int expectResult = 11;
        int actualResult = bai2.max(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testNull() {
        bai2.max(null);
    }

    @Test
    void testIsEmpty() {
        List<Integer> listInput = new ArrayList<>();
        int expectResult = 0;
        int actualResult = bai2.max(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testOneInput(){
        List<Integer> listInput = new ArrayList<>(Arrays.asList(1));
        int expectResult = 0;
        int actualResult = bai2.max(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
