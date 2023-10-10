package com.example.demo.level1;

import com.example.demo.level1.Bai7;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai7Test {
    private Bai7 bai7 =new Bai7();
    @Test
    void testInput(){
        List<String> list= new ArrayList<>(Arrays.asList("a","h","c","b"));
        List<String> listSapXep = new ArrayList<>(Arrays.asList("a","b","c","h"));
        Assertions.assertEquals(listSapXep,bai7.sapXep(list));
    }
    @Test
    void testSo(){
        List<String> list= new ArrayList<>(Arrays.asList("a","5","c","b"));
        List<String> listSapXep = new ArrayList<>(Arrays.asList("a","5","c","b"));
        Assertions.assertEquals(listSapXep,bai7.sapXep(list));
    }

    @Test
    void testIsEmpty(){
        List<String> emptyList=new ArrayList<>();
        List<Double> listSapXep=new ArrayList<>();
        Assertions.assertEquals(listSapXep,bai7.sapXep(emptyList));
    }

    @Test
    void testOneInput(){
        List<String> list= new ArrayList<>(Arrays.asList("a"));
        List<String> listSapXep= new ArrayList<>(Arrays.asList("a"));
        Assertions.assertEquals(listSapXep,bai7.sapXep(list));
    }


}
