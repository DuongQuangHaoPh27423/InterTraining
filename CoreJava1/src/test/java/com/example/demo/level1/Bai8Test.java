package com.example.demo.level1;

import com.example.demo.level1.Bai8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Bai8Test {

    Bai8 bai8 = new Bai8();

    @Test
    void testInputSoChan() {
        int[] list = {1, 2, 3, 4};
        double expectResult = 2.5;
        double actualResult = bai8.findMedian(list);
        Assertions.assertEquals(expectResult, actualResult);

    }

    @Test
    void testInputSoLe() {
        int[] list = {1, 2, 3};
        double expectResult = 2.0;
        double actualResult = bai8.findMedian(list);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testNull() {
        int[] list = {};
        double expectResult = Double.NaN;
        double actualResult = bai8.findMedian(list);
        Assertions.assertEquals(expectResult, actualResult);
    }


    @Test
    void testOneInput() {
        int[] list = {1};
        double expectResult = 1;
        double actualResult = bai8.findMedian(list);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
