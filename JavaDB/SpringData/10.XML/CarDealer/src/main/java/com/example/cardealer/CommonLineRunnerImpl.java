package com.example.cardealer;

import com.example.cardealer.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public class CommonLineRunnerImpl implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final Scanner scanner;

    public CommonLineRunnerImpl(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
//        seedDate();
        System.out.println("Enter query number to test:");
        int query = Integer.parseInt(scanner.nextLine());
        switch (query){
            case 1 -> orderedCustomersByBirthDate();
        }
    }

    private void orderedCustomersByBirthDate() throws JAXBException {
        customerService.printInFailOrderCustomersByDate();
    }

    private void seedDate() throws JAXBException, FileNotFoundException {
        if (supplierService.getCount() == 0){
            supplierService.importDate();
        };

        if(partService.getCount() == 0){
            partService.importDate();
        }

        if(carService.getCount() == 0){
            carService.importDate();
        }

        if(customerService.getCount() == 0){
            customerService.importDate();
        }

        if(saleService.getCount() == 0){
            saleService.importDate();
        }
    }
}
