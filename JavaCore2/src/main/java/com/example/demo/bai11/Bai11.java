package com.example.demo.bai11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai11 {
    private static Map<String, String> listDirect = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int select;
        do {
            System.out.println("1. Thêm từ vào từ điển");
            System.out.println("2. Tra cứu từ điển");
            System.out.println("3. Thoát");
            System.out.print("Chọn tùy chọn: ");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.println("Mời nhập từ cần thêm vào từ điển:\n");
                    String word = sc.next();
                    System.out.println("Mời nhập định nghĩa của từ:\n");
                    String defini = sc.next();
                    addNew(word, defini);
                    break;
                case 2:
                    System.out.println("\nNhập từ cần tra cứu:");
                    String work = sc.next();
                    findWord(work);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("mời nhập lại");
            }
        } while (select != 3);

    }

    static String addNew(String word, String defini) {

        if (word == null) {
            System.out.println("rỗng!");
            return "err";
        }
        Pattern checkSo = Pattern.compile(".*\\d+.*");
        Matcher matcher = checkSo.matcher(word);
        Matcher matcher1 = checkSo.matcher(defini);
        if (matcher.find() || matcher1.find()) {
            System.out.println("không được nhập số!");
            return "err";
        }
        if (word == "") {
            System.out.println("từ không được để trống!");
            return word;
        } else {
            listDirect.put(word, defini);
            System.out.println(" Thêm thành công từ " + word + "!");
            return word;
        }

    }

    static void findWord(String work) {

        String denifi = listDirect.get(work);
        if (listDirect.containsKey(work)) {
            System.out.println("\nĐịnh nghĩa của từ: " + denifi);
        } else {
            System.out.println("\nKhông tìm thấy từ cần tra cứu!");
        }
    }
}
