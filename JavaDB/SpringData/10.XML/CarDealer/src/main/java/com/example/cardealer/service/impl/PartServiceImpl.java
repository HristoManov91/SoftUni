package com.example.cardealer.service.impl;

import com.example.cardealer.model.dto.PartSeedRootDto;
import com.example.cardealer.model.entity.Part;
import com.example.cardealer.repository.PartRepository;
import com.example.cardealer.service.PartService;
import com.example.cardealer.service.SupplierService;
import com.example.cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class PartServiceImpl implements PartService {

    private static final String PARTS_FILE_PATH = "src/main/resources/files/parts.xml";

    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final SupplierService supplierService;

    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, XmlParser xmlParser, SupplierService supplierService) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.supplierService = supplierService;
    }

    @Override
    public long getCount() {
        return partRepository.count();
    }

    @Override
    public void importDate() throws JAXBException, FileNotFoundException {
        PartSeedRootDto partSeedRootDto = xmlParser.fromFile(PARTS_FILE_PATH, PartSeedRootDto.class);

        partSeedRootDto.getParts()
                .stream()
                .map(partSeedDto -> {
                    Part part = modelMapper.map(partSeedDto, Part.class);
                    part.setSupplier(supplierService.getRandomSupplier());
                    return part;
                })
                .forEach(partRepository::save);
    }

    @Override
    public Set<Part> getRandomParts() {
        Set<Part> parts = new HashSet<>();
        int count = ThreadLocalRandom.current().nextInt(10 , 21);
        for (int i = 0; i < count; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1 , partRepository.count() + 1);
            partRepository.findById(randomId).ifPresent(parts::add);
        }
        return parts;
    }
}
