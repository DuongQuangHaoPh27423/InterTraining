package com.example.demo.level1;

import com.example.demo.level1.Bai5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai5Test {
    private Bai5 bai5 = new Bai5();

    @Test
    void testInPutShort() {
        List<String> list = new ArrayList<>(Arrays.asList("Hai", "12345", "hello", "123456"));
        String expectResult = "Hai";
        String actualResult = bai5.findShort(list);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInputGiongNhau() {
        List<String> list = new ArrayList<>(Arrays.asList("Hai", "4123", "Hai", "123456"));
        String expectResult = "Hai";
        String actualResult = bai5.findShort(list);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testChuoiCoCungDoDai() {
        List<String> list = new ArrayList<>(Arrays.asList("123", "Hai", "1111", "123456"));
        String expectResult = "123";
        String actualResult = bai5.findShort(list);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testListNull() {
        String expectResult = null;
        String actualResult = bai5.findShort(null);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testListIsEmpty() {
        List<String> list = new ArrayList<>();
        String expectResult = "";
        String actualResult = bai5.findShort(list);
        Assertions.assertEquals(expectResult, actualResult);
    }

}