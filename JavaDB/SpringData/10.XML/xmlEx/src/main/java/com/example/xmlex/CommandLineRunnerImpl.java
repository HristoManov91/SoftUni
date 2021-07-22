package com.example.xmlex;

import com.example.xmlex.model.dto.categoryDto.CategorySeedRootDto;
import com.example.xmlex.model.dto.productDto.ProductSeedRootDto;
import com.example.xmlex.model.dto.productDto.ProductViewRootDto;
import com.example.xmlex.model.dto.userDto.UserSeedRootDto;
import com.example.xmlex.model.dto.userDto.UserViewRootDto;
import com.example.xmlex.service.CategoryService;
import com.example.xmlex.service.ProductService;
import com.example.xmlex.service.UserService;
import com.example.xmlex.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String RESOURCES_FILES_PATH = "src/main/resources/files/";
    private static final String OUTPUT_FILES_PATH = "src/main/resources/files/output/";
    private static final String CATEGORIES_FILE_NAME = "categories.xml";
    private static final String USERS_FILE_NAME = "users.xml";
    private static final String PRODUCTS_FILE_NAME = "products.xml";
    private static final String PRODUCTS_IN_RANGE_Q1_FILE_NAME = "products-in-range-q1.xml";
    private static final String USERS_WITH_SOLD_PRODUCTS_Q2_FILE_NAME = "users-with-sold-products-q2.xml";

    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader reader;

    public CommandLineRunnerImpl(XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
//        seedDate();

        System.out.println("Select the query number you want to test:");
        int number = Integer.parseInt(reader.readLine());

        switch (number){
            case 1 -> productsInRange();
            case 2 -> successfullySoldProducts();
        }


    }

    private void successfullySoldProducts() throws JAXBException {
        UserViewRootDto usersWithMoreThanOneSoldProduct = userService.findAllUsersWithMoreThanOneSoldProduct();

        xmlParser.writeToFile(OUTPUT_FILES_PATH + USERS_WITH_SOLD_PRODUCTS_Q2_FILE_NAME , usersWithMoreThanOneSoldProduct);
    }

    private void productsInRange() throws JAXBException {
        ProductViewRootDto productsInRangeWithoutBuyer = productService.findProductsInRangeWithoutBuyer();

        xmlParser.writeToFile(OUTPUT_FILES_PATH + PRODUCTS_IN_RANGE_Q1_FILE_NAME , productsInRangeWithoutBuyer);
    }

    private void seedDate() throws JAXBException, FileNotFoundException {
        if (categoryService.getEntityCount() == 0){
            CategorySeedRootDto categorySeedRootDto =
                    xmlParser.fromFile(RESOURCES_FILES_PATH + CATEGORIES_FILE_NAME, CategorySeedRootDto.class);
            categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if (userService.getCount() == 0){
            UserSeedRootDto userSeedRootDto =
                    xmlParser.fromFile(RESOURCES_FILES_PATH + USERS_FILE_NAME, UserSeedRootDto.class);
            userService.seedUsers(userSeedRootDto.getUsers());
        }

        if (productService.getCount() == 0){
            ProductSeedRootDto productSeedRootDto =
                    xmlParser.fromFile(RESOURCES_FILES_PATH + PRODUCTS_FILE_NAME, ProductSeedRootDto.class);
            productService.seedProducts(productSeedRootDto.getProducts());
        }
    }
}
