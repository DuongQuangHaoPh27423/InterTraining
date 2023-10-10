package com.example.demo.bai6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBai6 {
    private Bai6 bai6 = new Bai6();

    @Test
    void testInput() {
        int[] arrInput = {7, 1, 5, 3, 6, 4};
        int expectResult = 5;
        int actualResult = bai6.MaxLoiNhuan(arrInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInput1() {
        int[] arrInput = {7};
        int expectResult = 0;
        int actualResult = bai6.MaxLoiNhuan(arrInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInput2() {
        int[] arrInput = {7, 0, 5, 3, 6, 4};
        int expectResult = 0;
        int actualResult = bai6.MaxLoiNhuan(arrInput);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testInput3() {
        int[] arrInput = { 1, 1, 3, 6};
        int expectResult = 5    ;
        int actualResult = bai6.MaxLoiNhuan(arrInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInputSoAm() {
        int[] arrInput = {7, 1, 5, 3, 6, -4};
        int expectResult = 0;
        int actualResult = bai6.MaxLoiNhuan(arrInput);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
