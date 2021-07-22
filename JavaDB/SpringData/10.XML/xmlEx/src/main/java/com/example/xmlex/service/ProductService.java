package com.example.xmlex.service;

import com.example.xmlex.model.dto.productDto.ProductSeedDto;
import com.example.xmlex.model.dto.productDto.ProductViewRootDto;
import com.example.xmlex.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    long getCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findProductsInRangeWithoutBuyer();
}
