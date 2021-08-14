package com.example.laptop.service.impl;

import com.example.laptop.model.dto.LaptopSeedRootDto;
import com.example.laptop.model.entity.Laptop;
import com.example.laptop.model.entity.WarrantyType;
import com.example.laptop.repository.LaptopRepository;
import com.example.laptop.service.LaptopService;
import com.example.laptop.service.ShopService;
import com.example.laptop.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {

    private static final String LAPTOP_FILE_PATH = "src/main/resources/files/json/laptops.json";

    private final LaptopRepository laptopRepository;
    private final ShopService shopService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopService shopService, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.laptopRepository = laptopRepository;
        this.shopService = shopService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOP_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder sb = new StringBuilder();

        LaptopSeedRootDto[] laptopSeedRootDtos = gson.fromJson(readLaptopsFileContent(), LaptopSeedRootDto[].class);

        Arrays.stream(laptopSeedRootDtos)
                .filter(laptopSeedRootDto -> {
                    boolean isValid = validationUtil.isValid(laptopSeedRootDto);
                    sb.append(isValid
                            ? String.format("Successfully imported Laptop %s - %.2f - %d - %d", laptopSeedRootDto.getMacAddress(),
                            laptopSeedRootDto.getCpuSpeed(), laptopSeedRootDto.getRam(), laptopSeedRootDto.getStorage())
                            : "Invalid Laptop")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(laptopSeedRootDto -> {
                    Laptop laptop = modelMapper.map(laptopSeedRootDto, Laptop.class);
//                    String warrantyType = laptopSeedRootDto.getWarrantyType();
//                    if (warrantyType.equals("BASIC") || warrantyType.equals("PREMIUM") || warrantyType.equals("LIFETIME")){
//                        laptop.setWarrantyType(WarrantyType.valueOf(warrantyType));
//                    }
                    laptop.setShop(shopService.findShopByName(laptopSeedRootDto.getShop().getName()));
                    return laptop;
                })
                .forEach(laptop -> {
                    try {
                        laptopRepository.save(laptop);
                    } catch (Exception e) {
                        sb.append("Invalid Laptop");
                    }
                });

        System.out.println();

        return sb.toString().trim();
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder sb = new StringBuilder();

        laptopRepository.findAllOrderBy()
                .forEach(laptop -> {
                    sb.append(String.format("Laptop - %s%n" +
                                    "*Cpu speed - %.2f%n" +
                                    "**Ram - %d%n" +
                                    "***Storage - %d%n" +
                                    "****Price - %.2f%n" +
                                    "#Shop name - %s%n" +
                                    "##Town - %s%n", laptop.getMacAddress(), laptop.getCpuSpeed(), laptop.getRam(),
                            laptop.getStorage(), laptop.getPrice(), laptop.getShop().getName(),
                            laptop.getShop().getTown().getName()))
                            .append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
}
