package com.george.springcourse.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "ФИО не должно быть пустым")
    @Size(min = 2, max = 100, message = "ФИО должно быть от 2 до 100 символов")
    private String fullName;

    @Min(value = 1900, message = "Год рожддения должен быть больше 1900")
    private int yearOfBirth;

    public Person() {}
    public Person(String fullName, int yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearOfBirth() { return yearOfBirth; }

    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }
}
