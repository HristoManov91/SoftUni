package com.ex.shopinglistapplication.service.impl;

import com.ex.shopinglistapplication.model.entity.CategoryEnum;
import com.ex.shopinglistapplication.model.entity.Product;
import com.ex.shopinglistapplication.model.service.ProductServiceModel;
import com.ex.shopinglistapplication.model.view.ProductViewModel;
import com.ex.shopinglistapplication.repository.ProductRepository;
import com.ex.shopinglistapplication.service.CategoryService;
import com.ex.shopinglistapplication.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel , Product.class);
        product.setCategory((categoryService.findByName(productServiceModel.getCategory())));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        BigDecimal sumOfProductPrice = productRepository.findTotalProductSum();
        return sumOfProductPrice == null ? BigDecimal.valueOf(0) : sumOfProductPrice;
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryEnum categoryName) {
       return productRepository.findAllByCategory_NameOrderByNeededBefore(categoryName)
                .stream().map(product -> modelMapper.map(product , ProductViewModel.class))
               .collect(Collectors.toList());
    }

    @Override
    public void buyById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAllProducts() {
        productRepository.deleteAll();
    }
}
