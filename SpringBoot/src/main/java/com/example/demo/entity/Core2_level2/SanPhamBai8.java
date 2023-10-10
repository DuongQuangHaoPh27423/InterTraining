package com.example.demo.entity.Core2_level2;

public class SanPhamBai8 {
    private String name;
    private double price;
    private int quality;

    public SanPhamBai8() {
    }

    public SanPhamBai8(String name, double price, int quality) {
        this.name = name;
        this.price = price;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quality=" + quality +
                '}';
    }
}
