package com.example.cardealer.service;

import com.example.cardealer.model.entity.Supplier;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface SupplierService {
    
    long getCount();

    void importDate() throws JAXBException, FileNotFoundException;

    Supplier getRandomSupplier();
}
