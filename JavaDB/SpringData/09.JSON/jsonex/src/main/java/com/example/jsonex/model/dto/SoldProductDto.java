package com.example.jsonex.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class SoldProductDto {

    @Expose
    private Long count;
    @Expose
    private Set<ProductSeedDto> products;

    public SoldProductDto() {
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Set<ProductSeedDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductSeedDto> products) {
        this.products = products;
    }
}
