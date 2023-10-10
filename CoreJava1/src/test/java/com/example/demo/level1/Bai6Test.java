package com.example.demo.level1;

import com.example.demo.level1.Bai6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai6Test {
    private Bai6 bai6 = new Bai6();

    @Test
    void testList() {
//        đầu vào
        List<Double> list = new ArrayList<>(Arrays.asList(10.5, 15.8, 77.2, 3.1, 20.0));
//         mong muốn
        List<Double> expectResult = new ArrayList<>(Arrays.asList(3.1, 10.5, 15.8, 20.0, 77.2));
        Assertions.assertEquals(expectResult, bai6.sapXep(list));
    }

    @Test
    void testListIsEmpty() {

        List<Double> emptyList = new ArrayList<>();
        List<Double> sapXep = new ArrayList<>();
        Assertions.assertEquals(sapXep, bai6.sapXep(emptyList));
    }


    @Test
    void testChuoiCoCungGiaTri() {
        List<Double> input = new ArrayList<>(Arrays.asList(10.5, 15.8, 10.5, 3.1, 20.0));
        List<Double> sapXep = new ArrayList<>(Arrays.asList(3.1, 10.5, 10.5, 15.8, 20.0));
        Assertions.assertEquals(sapXep, bai6.sapXep(input));
    }

    @Test
    void testChuoiCo1GiaTri() {
        List<Double> input = new ArrayList<>(Arrays.asList(1.0));
        List<Double> sapXep = new ArrayList<>(Arrays.asList(1.0));
        Assertions.assertEquals(sapXep, bai6.sapXep(input));
    }

    @Test
    void testChuoiCoGiaTriBangNhau() {
//đàu vào
        List<Double> input = new ArrayList<>(Arrays.asList(5.0, 2.0, 3.0, 2.0, 3.0, 5.0));
        List<Double> sapXep = new ArrayList<>(Arrays.asList(2.0, 2.0, 3.0, 3.0, 5.0, 5.0));
        Assertions.assertEquals(sapXep, bai6.sapXep(input));
    }
}
