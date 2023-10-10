package com.example.demo.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai4Test {
    private Bai4 bai4 = new Bai4();

    @Test
    void testInput() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 10, 15));
        int exactResult = 15;
        int actualResult = bai4.Tong(listInput);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void testNone() {
        List<Integer> listInput = new ArrayList<>(Arrays.asList(4, 5, 6, 10, 7));
        int exactResult = 0;
        int actualResult = bai4.Tong(listInput);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void testIsEmpty() {
        List<Integer> listInput = new ArrayList<>();
        int exactResult = 0;
        int actualResult = bai4.Tong(listInput);
        Assertions.assertEquals(exactResult, actualResult);
    }

    @Test
    void testNull() {

        bai4.Tong(null);
    }


}
