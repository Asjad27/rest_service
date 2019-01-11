package com.asjad.rest.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class People {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String city;
    private int age;
    private String occupation;
    private double annualTax;

    public People(String name, String city, int age, String occupation, double annualTax) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.occupation = occupation;
        this.annualTax = annualTax;
    }

    public People(){}
}