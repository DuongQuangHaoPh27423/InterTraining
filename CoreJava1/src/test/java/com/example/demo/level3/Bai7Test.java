package com.example.demo.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Bai7Test {
    private Bai7 bai7 = new Bai7();

    @Test
    void testInputTrue() {
        String input = "A man a plan a canal Panama";
        Boolean exceptResult = true;
        Boolean actualResult = bai7.daoNguoc(input);
        Assertions.assertEquals(exceptResult, actualResult);
    }


    @Test
    void testInputFalse() {
        String input = "Duong Quang Hao";
        Boolean exceptResult = false;
        Boolean actualResult = bai7.daoNguoc(input);
        Assertions.assertEquals(exceptResult, actualResult);
    }

    @Test
    void testKyTuDacBiet() {
        String input = "Duong Quang Hao@!#@";
        Boolean exceptResult = false;
        Boolean actualResult = bai7.daoNguoc(input);
        Assertions.assertEquals(exceptResult, actualResult);
    }

    @Test
    void testIsEmpty() {
        String input = "";
        Boolean exceptResult = false;
        Boolean actualResult = bai7.daoNguoc(input);
        Assertions.assertEquals(exceptResult, actualResult);
    }

    @Test
    void testNull() {
        bai7.daoNguoc(null);
    }


}
