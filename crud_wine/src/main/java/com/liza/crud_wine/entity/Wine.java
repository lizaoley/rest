package com.liza.crud_wine.entity;

import jakarta.persistence.*;

@Entity
@Table(name="wine")
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "sweetness_wine")
    private String sweetnessWine;

    @Column(name = "color_wine")
    private String colorWine;

    @Column(name = "year_wine")
    private int yearWine;

    public Wine() {
    }

    public Wine(String brand, String sweetnessWine, String colorWine, int yearWine) {
        this.brand = brand;
        this.sweetnessWine = sweetnessWine;
        this.colorWine = colorWine;
        this.yearWine = yearWine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSweetnessWine() {
        return sweetnessWine;
    }

    public void setSweetnessWine(String sweetnessWine) {
        this.sweetnessWine = sweetnessWine;
    }

    public String getColorWine() {
        return colorWine;
    }

    public void setColorWine(String colorWine) {
        this.colorWine = colorWine;
    }

    public int getYearWine() {
        return yearWine;
    }

    public void setYearWine(int yearWine) {
        this.yearWine = yearWine;
    }

    @Override
    public String toString() {
        return "Вино: " +
                "id №" + id +
                ", бренд - " + brand +
                ", сахар - " + sweetnessWine +
                ", цвет вина - " + colorWine +
                ", год урожая - " + yearWine +
                '.';
    }
}
