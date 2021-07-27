package com.example.cardealer.service.impl;

import com.example.cardealer.model.dto.SupplierSeedRootDto;
import com.example.cardealer.model.entity.Supplier;
import com.example.cardealer.repository.SupplierRepository;
import com.example.cardealer.service.SupplierService;
import com.example.cardealer.util.ValidationUtil;
import com.example.cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static final String SUPPLIERS_FILE_PATH = "src/main/resources/files/suppliers.xml";

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getCount() {
        return supplierRepository.count();
    }

    @Override
    public void importDate() throws JAXBException, FileNotFoundException {
        SupplierSeedRootDto supplierSeedRootDto = xmlParser.fromFile(SUPPLIERS_FILE_PATH, SupplierSeedRootDto.class);

       supplierSeedRootDto.getSupplierSeedDtos()
                .stream()
                .map(supplierSeedDto -> modelMapper.map(supplierSeedDto, Supplier.class))
                .forEach(supplierRepository::save);
    }

    @Override
    public Supplier getRandomSupplier() {
        long randomId = ThreadLocalRandom.current().nextLong(1 , supplierRepository.count() + 1);

        return supplierRepository.findById(randomId).orElse(null);
    }
}
