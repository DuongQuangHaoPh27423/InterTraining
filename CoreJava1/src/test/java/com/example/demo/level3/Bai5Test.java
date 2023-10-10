package com.example.demo.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai5Test {
    private Bai5 bai5 = new Bai5();

    @Test
    void testInput() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 20));
        int expectResult = 42;
        int actualReSult = bai5.Sum(listInput);
        Assertions.assertEquals(expectResult, actualReSult);
    }

    @Test
    void testOneInput() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(1));
        int expectResult = 2;
        int actualReSult = bai5.Sum(listInput);
        Assertions.assertEquals(expectResult, actualReSult);
    }

    @Test
    void testIsEmpty() {
        List<Integer> listInput = new ArrayList<>();
        int expectResult = 1;
        int actualReSult = bai5.Sum(listInput);
        Assertions.assertEquals(expectResult, actualReSult);
    }

    @Test
    void testNull() {
        bai5.Sum(null);
    }
}
