package com.example.demo.level2;

import java.util.List;

public class  Bai4 {
    public Integer Tong(List<Integer> list) {
        int sum = 0;
        if(list ==null){
            System.out.println("mảng rỗng");
            return null ;
        }
        if(list.isEmpty()){
            System.out.println("mảng trống");
            return sum;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 3 == 0 && list.get(i) % 5 == 0) {
                sum += list.get(i);
            }
        }

        if(sum==0){
            System.out.println("không có số nào chia hết cho 3 và 5");
            return sum;
        }
        System.out.println("Tổng các số chia hết cho 3 và 5 là:"+sum);
        return sum;
    }
}
