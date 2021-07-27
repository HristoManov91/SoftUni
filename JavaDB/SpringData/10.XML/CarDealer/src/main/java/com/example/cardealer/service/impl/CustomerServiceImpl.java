package com.example.cardealer.service.impl;

import com.example.cardealer.model.dto.CustomerViewDto;
import com.example.cardealer.model.dto.CustomerViewRootDto;
import com.example.cardealer.model.dto.CustomerSeedRootDto;
import com.example.cardealer.model.entity.Customer;
import com.example.cardealer.repository.CustomerRepository;
import com.example.cardealer.service.CustomerService;
import com.example.cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/customers.xml";
    private static final String CUSTOMERS_ORDER_BY_BIRTH_DATE_FILE_PATH = "src/main/resources/output/customer-order.xml";

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public long getCount() {
        return customerRepository.count();
    }

    @Override
    public void importDate() throws JAXBException, FileNotFoundException {
        CustomerSeedRootDto customerSeedRootDto = xmlParser.fromFile(CUSTOMERS_FILE_PATH, CustomerSeedRootDto.class);

        customerSeedRootDto.getCustomers()
                .stream()
                .map(customerSeedDto -> modelMapper.map(customerSeedDto, Customer.class))
                .forEach(customerRepository::save);

        System.out.println();
    }

    @Override
    public Customer getRandomCustomer() {
        long randomId = ThreadLocalRandom.current().nextLong(1, customerRepository.count() + 1);
        return customerRepository.findById(randomId).orElse(null);
    }

    @Override
    public void printInFailOrderCustomersByDate() throws JAXBException {
        List<Customer> customers = customerRepository.findAllCustomerOrderByBirthDateThanByYoungDriver();

        CustomerViewRootDto customerOutputRootDto = new CustomerViewRootDto();
        customerOutputRootDto
                .setCustomers(customers
                        .stream()
                        .map(customer -> modelMapper.map(customer, CustomerViewDto.class))
                        .collect(Collectors.toList()));

        xmlParser.writeToFile(CUSTOMERS_ORDER_BY_BIRTH_DATE_FILE_PATH , CustomerViewRootDto.class);
    }
}
