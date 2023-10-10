package com.example.demo.bai7;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBai7 {
    private Bai7 bai7 = new Bai7();

    @Test
    void testInput() {
        List<Double> diems = new ArrayList<>(List.of(7.0, 5.2, 6.6, 7.3, 5.3));
        double expectResult = 6.279999999999999;
        double actualResult = bai7.tinhDiem(diems);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInput1() {
        List<Double> diems = new ArrayList<>(List.of(-7.0, 5.2, 6.6, 7.3, 5.3));
        double expectResult = 0;
        double actualResult = bai7.tinhDiem(diems);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testInput2() {
        List<Double> diems = new ArrayList<>(List.of(7.0, 5.2, 6.6, 7.3, 10.2));
        double expectResult = 0;
        double actualResult = bai7.tinhDiem(diems);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testIsEmpty() {
        List<Double> diems = new ArrayList<>();
        double expectResult = 0;
        double actualResult = bai7.tinhDiem(diems);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testNull() {

        bai7.tinhDiem(null);
    }
}
