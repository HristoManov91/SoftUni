package com.example.cardealer.service.impl;

import com.example.cardealer.model.entity.Sale;
import com.example.cardealer.repository.SaleRepository;
import com.example.cardealer.service.CarService;
import com.example.cardealer.service.CustomerService;
import com.example.cardealer.service.SaleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CustomerService customerService;
    private final CarService carService;

    public SaleServiceImpl(SaleRepository saleRepository, CustomerService customerService, CarService carService) {
        this.saleRepository = saleRepository;
        this.customerService = customerService;
        this.carService = carService;
    }

    @Override
    public long getCount() {
        return saleRepository.count();
    }

    @Override
    public void importDate() {
        Set<Sale> sales = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Sale sale = new Sale();
            sale.setCustomer(customerService.getRandomCustomer());
            sale.setCar(carService.getRandomCar());
            sale.setDiscount(getRandomDiscount() + (sale.getCustomer().getYoungDriver() ? 5 : 0));
            sales.add(sale);
        }

        sales.forEach(saleRepository::save);
    }

    private Integer getRandomDiscount() {
        Integer[] discounts = new Integer[]{0 , 5 , 10 , 15 , 20 , 30 , 40 , 50};
        int randomId = ThreadLocalRandom.current().nextInt(0 , discounts.length);
        return discounts[randomId];
    }
}
