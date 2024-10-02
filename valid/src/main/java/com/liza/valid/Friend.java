package com.liza.valid;

import com.liza.valid.validation.CarNumber;
import jakarta.validation.constraints.*;

public class Friend {

    private String firstName;

    @NotNull(message = "Enter correct last name")
    @Size(min = 2, max = 100, message = "Enter correct last name")
    private String lastName;

    @NotNull(message = "Enter your age.")
    @Min(value = 18, message = "You must be older then 18.")
    @Max(value = 130, message = "You must be younger then 130.")
    private Integer age;

    @NotNull(message = "Enter correct zip code")
    @Pattern(regexp = "^[0-9]{6}", message = "Enter valid zip code. Only numbers, 6 digit.")
    private String zipCode;

    @CarNumber(value = "ENG", message = "Number must be England") // изменили дефолтное правило
    @NotNull(message = "Enter correct car number")
    private String carNumber;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
