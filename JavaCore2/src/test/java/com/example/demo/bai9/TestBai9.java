package com.example.demo.bai9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestBai9 {
    private Bai9 bai9 = new Bai9();

    @Test
    void testInput() {
        String text = "This is a test. This is only a test.";
        Map<String, Integer> mapInput = bai9.countWords(text);
        Assertions.assertEquals(5, mapInput.size());
        Assertions.assertEquals(2, mapInput.get("this"));
        Assertions.assertEquals(2, mapInput.get("is"));
        Assertions.assertEquals(2, mapInput.get("a"));
        Assertions.assertEquals(2, mapInput.get("test"));
    }

    @Test
    void testInput1() {
        String text = "Hello word";
        Map<String, Integer> mapInput = bai9.countWords(text);
        Assertions.assertEquals(1, mapInput.get("hello"));
        Assertions.assertEquals(1, mapInput.get("word"));
    }

    @Test
    void testIsEmpty() {
        String text = "";
        Map<String, Integer> mapInput = bai9.countWords(text);
        Assertions.assertEquals(null, mapInput.get(""));
    }

    @Test
    void testNull() {
        Map<String, Integer> mapInput = bai9.countWords(null);
    }

    @Test
    void testNo() {
        String text = "word";
        Map<String, Integer> mapInput = bai9.countWords(text);
        Assertions.assertEquals(1, mapInput.get("word"));
    }
}
