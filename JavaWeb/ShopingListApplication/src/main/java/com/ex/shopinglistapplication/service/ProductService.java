package com.ex.shopinglistapplication.service;

import com.ex.shopinglistapplication.model.entity.CategoryEnum;
import com.ex.shopinglistapplication.model.service.ProductServiceModel;
import com.ex.shopinglistapplication.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryEnum categoryName);

    void buyById(String id);

    void buyAllProducts();
}
