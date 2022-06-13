package ru.netology.domain;

public class Smartphone extends Product {

    private String manufacturer;


    public Smartphone(int SmartphoneId, String SmartphoneName, int SmartphoneCost, String manufacturer) {
        super.id = SmartphoneId;
        super.name = SmartphoneName;
        super.cost = SmartphoneCost;
        this.manufacturer = manufacturer;
    }
}