package com.example.laptop.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table (name = "laptops")
public class Laptop extends BasicEntity{

    private Double cpuSpeed;
    private String description;
    private String macAddress;
    private BigDecimal price;
    private Integer ram;
    private Integer storage;
    private WarrantyType warrantyType;
    private Shop shop;

    public Laptop() {
    }

    @Column (name = "cpu_speed" , nullable = false)
    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    @Column (name = "description" , columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column (name = "mac_address" , unique = true)
    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Column (name = "price" , nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column (name = "ram")
    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    @Column (name = "storage")
    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    @Column (name = "warranty_type")
    @Enumerated()
    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    @ManyToOne
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
