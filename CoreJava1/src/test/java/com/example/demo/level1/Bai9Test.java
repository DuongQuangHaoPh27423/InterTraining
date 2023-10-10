package com.example.demo.level1;

import com.example.demo.level1.Bai9;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Bai9Test {
    private Bai9 bai9 = new Bai9();

    @Test
    void testInput() {
        String input = "Hello kitty";
        int expectResult = 2;
        int actualResult = bai9.timSoTu(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testIsEmpty() {
        String input = "";
        int expectResult = 0;
        int actualResult = bai9.timSoTu(input);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void testNull() {
        bai9.timSoTu(null);
    }
}
