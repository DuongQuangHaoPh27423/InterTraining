package com.example.demo.bai8;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuanLySanPham {
    public static HashMap<String, SanPham> listSanPham = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int select;
        do {
            System.out.println("__________________________MENU____________________________");
            System.out.println("- 1.Thêm sản phẩm mới vào danh sách.                    -\n");
            System.out.println("- 2.Hiển thị danh sách tất cả các sản phẩm.             -\n");
            System.out.println("- 3.Tìm thông tin sản phẩm dựa trên mã sản phẩm.        -\n");
            System.out.println("- 4.Xóa sản phẩm khỏi danh sách dựa trên mã sản phẩm.   -\n");
            System.out.println("- 5.Cập nhật thông tin sản phẩm.                       -\n");
            System.out.println("- 6.Dừng chương trình.                                 -\n");
            System.out.println("_________________________________________________________\n");
            System.out.println("MỜI BẠN CHỌN CHỨC NĂNG!\n");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.println("THÊM SẢN PHẨM\n");
                    System.out.println("Mời bạn nhập mã sp: ");
                    String id = sc.next();
                    System.out.println("Mời bạn nhập tên sp: ");
                    String name = sc.next();
                    System.out.println("Mời bạn nhập giá sp: ");
                    double price = sc.nextDouble();
                    System.out.println("Mời bạn nhập số lượng sp: ");
                    int quality = sc.nextInt();
                    addNew(id, name, price, quality);
                    break;
                case 2:
                    System.out.println("DANH SÁCH SẢN PHẨM\n");
                    showAll();
                    break;
                case 3:
                    System.out.println("TÌM SẢN PHẨM");
                    System.out.println("nhập mã sản phẩm cần tìm:\n");
                    //        chống trôi lệnh
                    sc.nextLine();
                    String idFind = sc.next();
                    find(idFind);
                    break;
                case 4:

                    System.out.println("mời nhập mã sản phẩm cần xoá:");
                    sc.nextLine();
                    String idFind1 = sc.next();
                    System.out.println("XOÁ SẢN PHẨM");
                    remove(idFind1);
                    break;
                case 5:
                    System.out.println("CẬP NHẬT SẢN PHẨM");
                    System.out.println("mời nhập mã sản phẩm cần update:\n");
                    sc.nextLine();
                    String iđUpate = sc.next();
                    update(iđUpate);
                    break;
                case 6:
                    System.out.println("STOP");
                    break;
                default:
                    System.out.println("mời nhập lại");
            }

        } while (select != 6);
        sc.close();
    }

    //addNew
    public static void addNew(String id, String name, double price, int quality) {
        if (id == null || name == null) {
            System.out.println("không được để rỗng");
            return;

        }
        if (id.isEmpty() || name.isEmpty()) {
            System.out.println("không được bỏ trống");
            return;

        }

        if (listSanPham.containsKey(id)) {
            System.out.println("đã tồn tại SP;");
        } else {
            if (price <= 0 || quality <= 0) {
                System.out.println("phải nhập giá hoặc sl >0");
                return;
            }
            SanPham sanPham = new SanPham(name, price, quality);
            listSanPham.put(id, sanPham);
            System.out.println("Thêm thành công");
        }
    }

    //    show
    public static void showAll() {
        for (Map.Entry<String, SanPham> sanPham : listSanPham.entrySet()) {
            System.out.println(sanPham.getKey() + "-" + sanPham.getValue().toString() + "\n");
        }
    }

    //find sản phẩm
    public static String find(String idFind) {

        if (listSanPham.containsKey(idFind)) {
            System.out.println("Thông tin sản phẩm:\n");
            SanPham sanPham = listSanPham.get(idFind);
            System.out.println(sanPham.toString());
            return sanPham.toString();
        } else {

            return "không tìm thấy sp";
        }
    }

    //    xoá
    public static String remove(String idFind) {

        if (listSanPham.containsKey(idFind)) {
            listSanPham.remove(idFind);
            System.out.println("xoá thành công");
            return "xoá thành công";
        } else {
            return "xoá thất bại";
        }
    }

    //    update
    public static String update(String iđUpate) {

        if (listSanPham.containsKey(iđUpate)) {
            SanPham sanPham = listSanPham.get(iđUpate);
            System.out.println("mời cập nhập tên sản phẩm:");
            String nameUpdate = sc.next();
            System.out.println("mời cập nhập giá sản phẩm:");
            double priceUpdate = sc.nextDouble();
            System.out.println("mời cập nhập số lượng sản phẩm:");
            int qualityUpdate = sc.nextInt();

            sanPham.setName(nameUpdate);
            sanPham.setPrice(priceUpdate);
            sanPham.setQuality(qualityUpdate);
            System.out.println("Cập nhật thành công!");
            return "Cập nhật thành công!";
        } else {
            System.out.println("FALSE");
            return "FALSE";
        }
    }
}
