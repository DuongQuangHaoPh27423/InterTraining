package com.example.demo.bai3;

import java.util.HashMap;
import java.util.Map;

public class Bai3 {

    public static void main(String[] args) {
        Map<String, Integer> person = new HashMap<>();
        person.put("Dương Quang Hào", 20);
        person.put("Trần Trung Hiếu", 19);
        person.put("Nguyễn Tuấn Anh", 19);
        person.put("Tạ Hữu Đại", 18);

//            Xuất
        for (Map.Entry<String, Integer> person1 : person.entrySet()) {
            System.out.println(person1.getKey());
        }
        String findPerson = "Dương Quang Hào";
        boolean containsKey = person.containsKey(findPerson);
        if (containsKey == true) {
            System.out.println("\nTuổi người đó là:" + person.get(findPerson));
        }
//        Remove
        String removePerson = "Tạ Hữu Đại";
        person.remove(removePerson);
        System.out.println("danh sách :");
        for (Map.Entry<String, Integer> person1 : person.entrySet()) {
            System.out.println(person1.getKey());
        }

//        check Exist
        String existPerson = "Trần Trung Hiếu";
        boolean containsKey1 = person.containsKey(existPerson);
        if (containsKey1 == true) {
            System.out.println("Tồn tại");
        } else {
            System.out.println("không tồn tại");
        }
    }
}
