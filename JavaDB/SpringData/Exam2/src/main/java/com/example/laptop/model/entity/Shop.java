package com.example.laptop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table (name = "shops")
public class Shop extends BasicEntity{

    private String address;
    private Integer employeeCount;
    private BigDecimal income;
    private String name;
    private Integer shopArea;
    private Town town;

    public Shop() {
    }

    @Column (name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column (name = "employee_count")
    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Column (name = "income")
    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    @Column (name = "name" , unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name = "shop_area")
    public Integer getShopArea() {
        return shopArea;
    }

    public void setShopArea(Integer shopArea) {
        this.shopArea = shopArea;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop)) return false;
        Shop shop = (Shop) o;
        return Objects.equals(address, shop.address) && Objects.equals(employeeCount, shop.employeeCount) && Objects.equals(income, shop.income) && Objects.equals(name, shop.name) && Objects.equals(shopArea, shop.shopArea) && Objects.equals(town, shop.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, employeeCount, income, name, shopArea, town);
    }
}
