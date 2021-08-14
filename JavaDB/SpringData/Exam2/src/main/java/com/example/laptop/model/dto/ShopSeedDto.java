package com.example.laptop.model.dto;

import com.example.laptop.model.entity.Town;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopSeedDto {

    @XmlElement(name = "address")
    private String address;
    @XmlElement(name = "employee-count")
    private Integer employeeCount;
    @XmlElement(name = "income")
    private BigDecimal income;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "shop-area")
    private Integer shopArea;
    @XmlElement(name = "town")
    private TownNameDto townName;

    @Size(min = 4)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Min(1)
    @Max(50)
    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Min(20000)
    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    @Size(min = 4)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(150)
    public Integer getShopArea() {
        return shopArea;
    }

    public void setShopArea(Integer shopArea) {
        this.shopArea = shopArea;
    }

    public TownNameDto getTownName() {
        return townName;
    }

    public void setTownName(TownNameDto townName) {
        this.townName = townName;
    }
}
