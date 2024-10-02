package com.liza.thymeleaf.model;

import java.util.List;

public class Friend {
    private String firstName;
    private String lastName;
    private String sex;
    private String city;
    private String favouriteDrink;
    private List<String> pets;

    public Friend() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFavouriteDrink() {
        return favouriteDrink;
    }

    public void setFavouriteDrink(String favouriteDrink) {
        this.favouriteDrink = favouriteDrink;
    }

    public List<String> getPets() {
        return pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Подруги и друзья: " +
                "имя - " + firstName +
                ", фамилия - " + lastName +
                ", пол - " + sex +
                ", страна - " + city +
                ", любимый напиток - " + favouriteDrink + '.';
    }
}
