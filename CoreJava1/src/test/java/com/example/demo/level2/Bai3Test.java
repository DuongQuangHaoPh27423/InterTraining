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
        String input1 = "abcdef";
        String input2 = "cdef";
        String expect = "cdef";
        String actual = bai3.timChuoiTrungLapLonNhat(input1, input2);
        Assertions.assertEquals(expect,actual);
    }
}
