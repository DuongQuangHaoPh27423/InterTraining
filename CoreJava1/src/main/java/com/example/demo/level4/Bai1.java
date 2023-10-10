package com.example.demo.level4;

public class Bai1 {

    public Integer count(int arr[]) {
        int temp;
        int i, j;
        boolean swapped = false;
        if (arr==null) {
            System.out.println("mangr khong duoc de rong");
            return null;
        }
        if (arr.length == 0) {
            System.out.println("mangr khong duoc de trong");
            return 0;
        }

        // lap qua tat ca cac so
        for (i = 0; i < arr.length - 1; i++) {
            swapped = false;

            // vong lap thu hai
            for (j = 0; j < arr.length - 1 - i; j++) {
                System.out.print("So sanh cac phan tu: [" + arr[j] + ", " + arr[j + 1] + "]");

                // kiem tra xem so ke tiep co nho hon so hien tai hay khong
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                    System.out.println(" => trao doi [" + arr[j] + ", " + arr[j + 1] + "]");
                } else {
                    System.out.println(" => khong can trao doi.");
                }
            }

            // neu khong can trao doi nua, tuc la
            // mang da duoc sap xep va thoat khoi vong lap.
            if (!swapped) {
                break;
            }
            System.out.println("Vong lap thu " + (i + 2));

        }
        if (i == 0) {
            System.out.println("khong can dung vong lap!");
            return i;
        }
        System.out.println("so lan la:" + (i + 1));
        return i + 1;

    }
}

