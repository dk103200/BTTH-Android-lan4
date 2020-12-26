package com.example.shopee;

public class FlashSale {
    private int img,gia,sell;

    public FlashSale(int img, int gia, int sell) {
        this.img = img;
        this.gia = gia;
        this.sell = sell;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }
}
