package com.example.demo.bai5;

import com.example.demo.bai15.Bai15;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBai5 {
    private bai5 bai5 = new bai5();

    @Test
    void testInput() {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        int[] expectResult = {0, 1};
        int[] actualResult = bai5.find(input, target);
        Assertions.assertEquals(expectResult,actualResult );
    }
}
