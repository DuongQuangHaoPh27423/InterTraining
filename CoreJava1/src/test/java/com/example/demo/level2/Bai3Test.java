package com.example.demo.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai3Test {
    private Bai3 bai3 = new Bai3();

    @Test
    void testInput() {
        List<String> listInput = new ArrayList<>(Arrays.asList("abcdef", "cdef"));
        String[] expectResult = {"cdef"};
        String[] actualResult = bai3.timChuoiTrungLapLonNhat(listInput);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
