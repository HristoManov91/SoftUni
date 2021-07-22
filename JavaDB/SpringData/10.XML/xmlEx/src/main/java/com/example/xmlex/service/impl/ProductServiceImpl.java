package com.example.xmlex.service.impl;

import com.example.xmlex.model.dto.productDto.ProductSeedDto;
import com.example.xmlex.model.dto.productDto.ProductViewRootDto;
import com.example.xmlex.model.dto.productDto.ProductWithSellerDto;
import com.example.xmlex.model.entity.Product;
import com.example.xmlex.repository.ProductRepository;
import com.example.xmlex.service.CategoryService;
import com.example.xmlex.service.ProductService;
import com.example.xmlex.service.UserService;
import com.example.xmlex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public long getCount() {
        return productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        products.stream()
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(userService.getRandomUser());
                    if (product.getPrice().compareTo(new BigDecimal(750L)) < 0) {
                        product.setBuyer(userService.getRandomUser());
                    }
                    product.setCategories(categoryService.randomCategories());
                    return product;
                })
                .forEach(productRepository::save);
    }

    @Override
    public ProductViewRootDto findProductsInRangeWithoutBuyer() {
        ProductViewRootDto productViewRootDto = new ProductViewRootDto();

        productViewRootDto
                .setProducts(productRepository
                        .findAllByPriceBetweenAndBuyerIsNull(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L))
                        .stream()
                        .map(product -> {
                            ProductWithSellerDto map = modelMapper.map(product, ProductWithSellerDto.class);
                            map.setSeller(String.format("%s %s" ,
                                    product.getSeller().getFirstName() ,
                                    product.getSeller().getLastName()));
                            return map;
                        })
                        .collect(Collectors.toList()));

        return productViewRootDto;
    }
}
