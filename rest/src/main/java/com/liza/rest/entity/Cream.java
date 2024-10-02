package com.liza.rest.entity;

public class Cream {

    private String brand;
    private String skinType;

    public Cream(String brand, String skinType) {
        this.brand = brand;
        this.skinType = skinType;
    }

    public Cream() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }
}
