package com.example.demo.service.core2Service;

import java.util.List;

public interface Bai7Service {
    void addNew(String name, List<Double> diems);

    double tinhDiem(List<Double> diems);
}
