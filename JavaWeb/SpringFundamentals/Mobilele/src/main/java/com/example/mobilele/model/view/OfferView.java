package com.example.mobilele.model.view;

import com.example.mobilele.model.entity.enums.EngineEnum;
import com.example.mobilele.model.entity.enums.TransmissionEnum;

public class OfferView {

    private long id;
    private String description;
    private EngineEnum engine;
    private String imageUrl;
    private int mileage;
    private int price;
    private TransmissionEnum transmission;
    private int year;
    private String model;
    private String brand;

    public OfferView() {
    }

    public long getId() {
        return id;
    }

    public OfferView setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferView setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferView setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferView setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferView setPrice(int price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferView setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferView setYear(int year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferView setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferView setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
