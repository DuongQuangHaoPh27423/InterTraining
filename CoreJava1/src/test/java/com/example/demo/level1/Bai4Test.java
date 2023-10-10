package com.example.demo.level1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai4Test {
    private Bai4 bai4 = new Bai4();

    @Test
     void testInput() {
        List<Double> numbers = new ArrayList<>(Arrays.asList(10.5, 7.2, 15.8, 3.1, 20.0));
        double expectResult = 20;
        double actualResult = bai4.findLargestNumber(numbers);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
     void testInPutNumberIsEmpty() {
        List<Double> numbers = new ArrayList<>();
        double expectResult = 0;
        double actualResult = bai4.findLargestNumber(numbers);
        Assertions.assertEquals(expectResult, actualResult);

    }

    @Test
     void testInputListNull() {
        double expectResult = Double.NaN;
        double actualResult = bai4.findLargestNumber(null);
        Assertions.assertEquals(expectResult, actualResult);

    }
    @Test
    void testInput2SoGiongNhau() {
        List<Double> numbers = new ArrayList<>(Arrays.asList(10.0, 5.2, 8.1, 10.0, 3.2, 2.1));
        double expectResult = 10;
        double actualResult = bai4.findLargestNumber(numbers);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testInputTatCaGiongNhau() {
        List<Double> numbers = new ArrayList<>(Arrays.asList(10.0, 10.0, 10.0 ,10.0,10.0, 10.0));
        double expectResult = 10;
        double actualResult = bai4.findLargestNumber(numbers);
        Assertions.assertEquals(expectResult, actualResult);
    }




}
