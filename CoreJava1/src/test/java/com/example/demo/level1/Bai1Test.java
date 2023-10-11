package com.example.demo.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class Bai1Test {
    private Bai1 bai1 = new Bai1();


    @Test
    void testAddTwoNumber() {
            String input = "2,3";
        int expectResult = 5;
        int actualResult= bai1.Sum(input);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testAddThreeNumber() {
            String input = "2,3,9";
        int expectResult = 0;
        int actualResult= bai1.Sum(input);
        Assertions.assertEquals(expectResult, actualResult);
    }
    @Test
    void testAddEmpty() {
        String input = "";
        int expectResult = 0;
        int actualResult= bai1.Sum(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testNull() {
        String input = null;
//        int expectResult = 0;
//        int actualResult= bai1.Sum(input);
//        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testAddChuCai(){
        String input = "32a,3";
        int expectResult = 0;
        int actualResult= bai1.Sum(input);
        Assertions.assertEquals(expectResult, actualResult);
    }



    }


