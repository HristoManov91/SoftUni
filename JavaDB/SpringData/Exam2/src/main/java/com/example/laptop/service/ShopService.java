package com.example.laptop.service;

import com.example.laptop.model.entity.Shop;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;


public interface ShopService {

    Shop findShopByName(String name);

    boolean areImported();

    String readShopsFileContent() throws IOException;

    String importShops() throws JAXBException, FileNotFoundException;
}
