package com.example.demo.bai12;

import java.util.*;

public class QuanLySanPham {
    static List<SanPham> listSanPham = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        listSanPham.add(new SanPham("1", "Hào", 5.5, new Date(2003, 2, 2)));
        listSanPham.add(new SanPham("2", "Hiếu", .1, new Date(2003, 3, 2)));
        listSanPham.add(new SanPham("3", "Anh", 5.2, new Date(2003, 4, 2)));
        listSanPham.add(new SanPham("4", "Nghĩa", 5.9, new Date(2003, 5, 2)));
        listSanPham.add(new SanPham("5", "Long", 7.1, new Date(2003, 6, 2)));
        int select;
        do {
            System.out.println("Sắp xếp theo:");
            System.out.println("1.Tên");
            System.out.println("2.Giá bán");
            System.out.println("3.Ngày sản Xuất");
            System.out.println("4.Giá bán và ngày sản xuất");
            System.out.println("5.OUT");
            System.out.print("Chọn tùy chọn: ");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.println("danh sách sắp xếp theo tên:\n");
                    sortByName(listSanPham);
                    hienThi(listSanPham);
                    break;
                case 2:
                    System.out.println("danh sách sắp xếp theo giá:\n");
                    sortByPrice(listSanPham);
                    hienThi(listSanPham);
                    break;
                case 3:
                    System.out.println("danh sách sắp xếp theo NSX:\n");
                    sortByDate(listSanPham);
                    hienThi(listSanPham);
                    break;
                case 4:
                    System.out.println("danh sách sắp xếp theo giá và NSX:\n");
                    sortByPriceAndate(listSanPham);
                    hienThi(listSanPham);
                    break;
                case 5:
                    System.out.println("STOP");
                    return;
                default:
                    System.out.println("Mời nhập lại");
            }
        } while (select != 5);
        sc.close();
    }

    static List<SanPham> sortByName(List<SanPham> listSanPham) {
        Collections.sort(listSanPham, Comparator.comparing(SanPham::getName));
        return listSanPham;
    }

    static List<SanPham> sortByPrice(List<SanPham> listSanPham) {
        Collections.sort(listSanPham, Comparator.comparing(SanPham::getPrice));
        return listSanPham;
    }

    static List<SanPham> sortByDate(List<SanPham> listSanPham) {
        Collections.sort(listSanPham, Comparator.comparing(SanPham::getDate));
        return listSanPham;
    }

    static List<SanPham> sortByPriceAndate(List<SanPham> listSanPham) {

        Collections.sort(listSanPham, Comparator.comparing(SanPham::getPrice).thenComparing(SanPham::getDate));
        return listSanPham;
    }

    static void hienThi(List<SanPham> listSanPham) {
        for (SanPham sanPham : listSanPham
        ) {
            System.out.println(sanPham);
        }
    }
}
