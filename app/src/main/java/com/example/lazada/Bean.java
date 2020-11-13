package com.example.lazada;

import java.text.DecimalFormat;

public class Bean {
    int img;
    String title;
    int price, discount;
    String country;

    public Bean(int img, String title, int price, int discount, String country) {
        this.img = img;
        this.title = title;
        this.price = price;
        this.discount = discount;
        this.country = country;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
