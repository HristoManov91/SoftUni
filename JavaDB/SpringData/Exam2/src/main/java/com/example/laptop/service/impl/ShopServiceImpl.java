package com.example.laptop.service.impl;

import com.example.laptop.model.dto.ShopSeedRootDto;
import com.example.laptop.model.entity.Shop;
import com.example.laptop.repository.ShopRepository;
import com.example.laptop.service.ShopService;
import com.example.laptop.service.TownService;
import com.example.laptop.util.ValidationUtil;
import com.example.laptop.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";

    private final ShopRepository shopRepository;
    private final TownService townService;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ShopServiceImpl(ShopRepository shopRepository, TownService townService, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.shopRepository = shopRepository;
        this.townService = townService;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Shop findShopByName(String name) {
        return shopRepository.findShopByName(name);
    }

    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        ShopSeedRootDto shopSeedRootDto = xmlParser.fromFile(SHOPS_FILE_PATH, ShopSeedRootDto.class);

        shopSeedRootDto.getShops()
                .stream()
                .filter(shopSeedDto -> {
                    boolean isValid = validationUtil.isValid(shopSeedDto);
                    sb.append(isValid
                            ? String.format("Successfully imported Shop %s - %s", shopSeedDto.getName(), shopSeedDto.getIncome())
                            : "Invalid shop")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(shopSeedDto -> {
                    Shop shop = modelMapper.map(shopSeedDto, Shop.class);
                    shop.setTown(townService.findTownByName(shopSeedDto.getTownName().getName()));
                    return shop;
                })
                .forEach(shop -> {
                    try {
                        shopRepository.save(shop);
                    } catch (Exception exception){
                        sb.append("Invalid Shop");
                    }
                });

        return sb.toString().trim();
    }
}
