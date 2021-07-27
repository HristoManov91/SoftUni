package com.example.cardealer.model.entity;

import javax.persistence.*;

@Entity
@Table (name = "sales")
public class Sale extends BaseEntity{

    private Integer discount;
    private Car car;
    private Customer customer;

    public Sale() {
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
