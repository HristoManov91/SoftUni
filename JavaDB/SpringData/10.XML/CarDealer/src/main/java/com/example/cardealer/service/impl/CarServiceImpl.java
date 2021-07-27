package com.example.cardealer.service.impl;

import com.example.cardealer.model.dto.CarSeedRootDto;
import com.example.cardealer.model.entity.Car;
import com.example.cardealer.model.entity.Part;
import com.example.cardealer.repository.CarRepository;
import com.example.cardealer.service.CarService;
import com.example.cardealer.service.PartService;
import com.example.cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private static final String CARS_FILE_PATH = "src/main/resources/files/cars.xml";

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final PartService partService;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, XmlParser xmlParser, PartService partService) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.partService = partService;
    }


    @Override
    public long getCount() {
        return carRepository.count();
    }

    @Override
    public void importDate() throws JAXBException, FileNotFoundException {
        CarSeedRootDto carSeedRootDto = xmlParser.fromFile(CARS_FILE_PATH, CarSeedRootDto.class);

        carSeedRootDto.getCars()
                .stream()
                .map(carSeedDto -> {
                    Car car = modelMapper.map(carSeedDto, Car.class);
                    car.setParts(partService.getRandomParts());
                    return car;
                })
                .forEach(carRepository::save);
    }

    @Override
    public Car getRandomCar() {
        long randomId = ThreadLocalRandom.current().nextLong(1 ,carRepository.count() + 1);
        return carRepository.findById(randomId).orElse(null);
    }
}
