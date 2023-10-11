package com.example.demo.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai2Test {
    private Bai2 bai2 = new Bai2();

    @Test
    void testInput() {
        List<String> listInput = new ArrayList<>(Arrays.asList("hihi", "Quang", "Hao", "Duong QuangHao"));
        String expectResult = "Duong QuangHao";
        String actualResult = bai2.findLongWord(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testIsEmpty() {
        List<String> emptyList = new ArrayList<>();
        String expectResult = "";
        String actualResult = bai2.findLongWord(emptyList);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testNull() {
        bai2.findLongWord(null);
    }


    @Test
    void testOneInput() {
        List<String> listInput = new ArrayList<>(Arrays.asList("Duong Quang Hao"));
        String expectResult = "Duong Quang Hao";
        String actualResult = bai2.findLongWord(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInputNumber() {
        List<String> listInput = new ArrayList<>(Arrays.asList("Hao", "Quang5", "Hao", "Duong Quang Hao"));
        String expectResult = "Duong Quang Hao";
        String actualResult = bai2.findLongWord(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testInputKytu() {
        List<String> listInput = new ArrayList<>(Arrays.asList("Hao", "Quang!", "Hao", "Duong Quang Hao"));
        String expectResult = "Duong Quang Hao";
        String actualResult = bai2.findLongWord(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
