package com.example.project02.model;

public class Proba {

    private String name;
    private String imgSrc;
    private String color;
    private double priceLabel;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public double getPrice() {
        return priceLabel;
    }

    public void setPrice(double priceLabel) {
        this.priceLabel = priceLabel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
