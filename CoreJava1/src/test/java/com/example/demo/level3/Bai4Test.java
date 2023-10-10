package com.example.demo.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai4Test {

    @Test
    void testInput1() {
        List<String> strings = new ArrayList<>();
        strings.add("abcd");
        strings.add("acdf");
        strings.add("efgh");
        strings.add("ijkl");

        String[] expected = {"abcd", "acdf"};
        String[] actual = Bai4.findLargestOverlap(strings);
//        sửa  expected->  Arrays.toString(expected)
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }
}
