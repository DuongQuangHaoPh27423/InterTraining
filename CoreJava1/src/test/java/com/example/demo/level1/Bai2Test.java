package com.example.demo.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Bai2Test {

    private Bai2 bai2 = new Bai2();

    @Test
    void TestInput() {
        String input = "asdasdada";
        int expectResult = 9;
        int actualResult = bai2.nhapChuoi(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void TestNull() {
        String input = "";
        int expectResult = 0;
        int actualResult = bai2.nhapChuoi(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void TestAddNumber() {
        String input = "hao1231";
        int expectResult = 0;
        int actualResult = bai2.nhapChuoi(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void TestKyTuDacBiet() {
        String input = "!@#$";
        int expectResult = 0;
        int actualResult = bai2.nhapChuoi(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void TestKhoangTrang() {
        String input = "duong quan ";
        int expectResult = 0;
        int actualResult = bai2.nhapChuoi(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

}
