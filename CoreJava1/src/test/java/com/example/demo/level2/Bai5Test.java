package com.example.demo.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai5Test {
    private Bai5 bai5 = new Bai5();

    @Test
    void testInput() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(1, 4, -3, 5, 2));
        Integer expectResult = 5;
        Integer actualResult = bai5.findMax(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testIsEmpty() {
        List<Integer> listInput = new ArrayList<>();
        Integer expectResult = 0;
        Integer actualResult = bai5.findMax(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    public void testNul () {
        bai5.findMax(null);
    }

}
