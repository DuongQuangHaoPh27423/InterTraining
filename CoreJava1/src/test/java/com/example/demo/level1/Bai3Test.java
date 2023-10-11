package com.example.demo.level1;

import com.example.demo.level1.Bai3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Bai3Test {
    private Bai3 bai3 = new Bai3();

    @Test
    void TestInputInteger() {
        String input = "-5";
        int expectResult = 25;
        double actualResult = bai3.tinhBinhPhuong(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void TestInputDouble() {
        String input = "2.5";
        Double expectResult = 0.0;
        Double actualResult = bai3.tinhBinhPhuong(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void TestInputString() {
        String input = "hap123";
        int expectResult = 0;
        Double actualResult = bai3.tinhBinhPhuong(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void TestInputKyTuDb() {
        String input = "@132";
        int expectResult = 0;
        Double actualResult = bai3.tinhBinhPhuong(input);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void TestInputKhoangTrang() {
        String input = "2 3";
        int expectResult = 0;
        Double actualResult = bai3.tinhBinhPhuong(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

}
