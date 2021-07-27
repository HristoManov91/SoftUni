package com.example.cardealer.service;

import com.example.cardealer.model.entity.Customer;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CustomerService {
    long getCount();

    void importDate() throws JAXBException, FileNotFoundException;

    Customer getRandomCustomer();

    void printInFailOrderCustomersByDate() throws JAXBException;
}
