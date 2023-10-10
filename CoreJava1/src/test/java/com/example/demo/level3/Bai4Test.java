package com.example.demo.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Bai4Test {

    @Test
    void testInput1() {
        List<String> strings = new ArrayList<>();
        strings.add("ABCD");
        strings.add("ACDF");
        strings.add("EFGH");
        strings.add("IJKL");

        String[] expected = {"ABCD", "ACDF"};
        String[] actual = Bai4.findLargestOverlap(strings);

        Assertions.assertEquals(expected, actual);
    }
}
