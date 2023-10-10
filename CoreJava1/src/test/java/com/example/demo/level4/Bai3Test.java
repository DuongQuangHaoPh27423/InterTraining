package com.example.demo.level4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Bai3Test {
    private Bai3 bai3 = new Bai3();

    @Test
    public void testInput() {
        String[] inputStrings = {"abcdef", "abcfed", "123abcdef456", "789abcdef123"};
        Integer expect = 3;
        Integer actual = bai3.Long(inputStrings);
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void testInput1() {
        String[] inputStrings = {"apple", "banana", "cherry"};
        Integer expect =0;
        Integer actual = bai3.Long(inputStrings);
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void testInput1Null(){
        String[] inputStrings = {};
        Integer expect =0;
        Integer actual = bai3.Long(inputStrings);
        Assertions.assertEquals(expect, actual);
    }
    @Test
    public void testInput1Value(){
        String[] inputStrings = {"abc"};
        Integer expect =0;
        Integer actual = bai3.Long(inputStrings);
        Assertions.assertEquals(expect, actual);
    }
}
