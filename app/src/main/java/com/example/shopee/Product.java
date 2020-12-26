package com.example.shopee;

public class Product {
    private String name, img,gia_cu, gia_moi;

    public Product(String name, String img, String gia_cu, String gia_moi) {
        this.name = name;
        this.img = img;
        this.gia_cu = gia_cu;
        this.gia_moi = gia_moi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGia_cu() {
        return gia_cu;
    }

    public void setGia_cu(String gia_cu) {
        this.gia_cu = gia_cu;
    }

    public String getGia_moi() {
        return gia_moi;
    }

    public void setGia_moi(String gia_moi) {
        this.gia_moi = gia_moi;
    }
}
