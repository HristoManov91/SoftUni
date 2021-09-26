package com.example.mobilele.init;

import com.example.mobilele.model.entity.BrandEntity;
import com.example.mobilele.model.entity.ModelEntity;
import com.example.mobilele.model.entity.OfferEntity;
import com.example.mobilele.model.entity.UserEntity;
import com.example.mobilele.model.entity.enums.CategoryEnum;
import com.example.mobilele.model.entity.enums.EngineEnum;
import com.example.mobilele.model.entity.enums.TransmissionEnum;
import com.example.mobilele.model.entity.enums.UserRoleEnum;
import com.example.mobilele.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;

@Component
public class DBInit implements CommandLineRunner {

    private final UserRoleService userRoleService;
    private final UserService userService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;
    private final PasswordEncoder passwordEncoder;

    public DBInit(UserRoleService userRoleService, UserService userService, BrandService brandService, ModelService modelService, OfferService offerService, PasswordEncoder passwordEncoder) {
        this.userRoleService = userRoleService;
        this.userService = userService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        userRoleService.initRoles();
//        initUsers();
        initBrands();
        initModels();
        initOffers();
    }

    private void initOffers() {
        OfferEntity offer1 = new OfferEntity()
                .setCreated(Instant.now())
                .setEngine(EngineEnum.HYBRID)
                .setMileage(50000)
                .setTransmission(TransmissionEnum.AUTOMATIC)
                .setModel(modelService.findByName("Avensis"))
                .setPrice(BigDecimal.valueOf(20500))
                .setSeller(userService.findUserById(1L))
                .setYear(2021)
                .setDescription("Много добра карана от баба в германия до магазина")
                .setImageUrl(modelService.findByName("Avensis").getImageUrl());

        offerService.saveOffer(offer1);

        OfferEntity offer2 = new OfferEntity()
                .setCreated(Instant.now())
                .setEngine(EngineEnum.DIESEL)
                .setMileage(40000)
                .setTransmission(TransmissionEnum.AUTOMATIC)
                .setModel(modelService.findByName("E class"))
                .setPrice(BigDecimal.valueOf(50500))
                .setSeller(userService.findUserById(2L))
                .setYear(2019)
                .setDescription("Много добра карана от баба в германия до магазина")
                .setImageUrl(modelService.findByName("E class").getImageUrl());

        offerService.saveOffer(offer2);

        OfferEntity offer3 = new OfferEntity()
                .setCreated(Instant.now())
                .setEngine(EngineEnum.GASOLINE)
                .setMileage(15000)
                .setTransmission(TransmissionEnum.MANUAL)
                .setModel(modelService.findByName("Xblade"))
                .setPrice(BigDecimal.valueOf(25500))
                .setSeller(userService.findUserById(1L))
                .setYear(2021)
                .setDescription("Много добра,бърз и надежден")
                .setImageUrl(modelService.findByName("Xblade").getImageUrl());

        offerService.saveOffer(offer3);

        OfferEntity offer4 = new OfferEntity()
                .setCreated(Instant.now())
                .setEngine(EngineEnum.DIESEL)
                .setMileage(555000)
                .setTransmission(TransmissionEnum.AUTOMATIC)
                .setModel(modelService.findByName("170"))
                .setPrice(BigDecimal.valueOf(115500))
                .setSeller(userService.findUserById(2L))
                .setYear(2021)
                .setDescription("Много добър,обслужен и икономичен")
                .setImageUrl(modelService.findByName("170").getImageUrl());

        offerService.saveOffer(offer4);

        OfferEntity offer5 = new OfferEntity()
                .setCreated(Instant.now())
                .setEngine(EngineEnum.ELECTRIC)
                .setMileage(255000)
                .setTransmission(TransmissionEnum.AUTOMATIC)
                .setModel(modelService.findByName("Tourismo"))
                .setPrice(BigDecimal.valueOf(135500))
                .setSeller(userService.findUserById(1L))
                .setYear(2021)
                .setDescription("Много добър,обслужен и икономичен")
                .setImageUrl(modelService.findByName("Tourismo").getImageUrl());

        offerService.saveOffer(offer5);
    }

    private void initModels() {
        ModelEntity avensis = new ModelEntity()
                .setBrand(brandService.findBrandById(1))
                .setCategory(CategoryEnum.CAR)
                .setCreated(Instant.now())
                .setName("Avensis")
                .setStartYear(1997)
                .setEndYear(2018)
                .setImageUrl("https://quickbutik.imgix.net/13175t/products/5dea3a372b553.jpeg");

        modelService.saveModel(avensis);

        ModelEntity eClass = new ModelEntity()
                .setBrand(brandService.findBrandById(2))
                .setCategory(CategoryEnum.CAR)
                .setCreated(Instant.now())
                .setName("E class")
                .setStartYear(1953)
                .setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.auto-data.net%2Fen%2Fmercedes-benz-e-class-model-1393&psig=AOvVaw2vZMWLSShwGYZNKIa-zLBD&ust=1632472762682000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCPjToovZlPMCFQAAAAAdAAAAABAD");

        modelService.saveModel(eClass);

        ModelEntity xblade = new ModelEntity()
                .setBrand(brandService.findBrandById(3))
                .setCategory(CategoryEnum.MOTORCYCLE)
                .setCreated(Instant.now())
                .setName("Xblade")
                .setStartYear(2018)
                .setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.carandbike.com%2Fhonda-bikes%2Fx-blade&psig=AOvVaw2lBAsWpAamn1ejp0fAYcwB&ust=1632472947899000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMjRmuPZlPMCFQAAAAAdAAAAABAD");

        modelService.saveModel(xblade);

        ModelEntity scania170 = new ModelEntity()
                .setBrand(brandService.findBrandById(4))
                .setCategory(CategoryEnum.TRUCK)
                .setCreated(Instant.now())
                .setName("170")
                .setStartYear(2021)
                .setImageUrl("https://i.pinimg.com/736x/e8/67/c2/e867c244c0d984dcfab76680b11ca43c.jpg");

        modelService.saveModel(scania170);

        ModelEntity tourismo = new ModelEntity()
                .setBrand(brandService.findBrandById(2))
                .setCategory(CategoryEnum.BUSS)
                .setCreated(Instant.now())
                .setName("Tourismo")
                .setStartYear(2000)
                .setImageUrl("https://i.ytimg.com/vi/CDDkbcJbdig/maxresdefault.jpg");

        modelService.saveModel(tourismo);


    }

    private void initBrands() {
        BrandEntity toyota = new BrandEntity().setName("Toyota").setCreated(Instant.now());
        brandService.saveBrand(toyota);
        BrandEntity mercedes = new BrandEntity().setName("Mercedes").setCreated(Instant.now());
        brandService.saveBrand(mercedes);
        BrandEntity honda = new BrandEntity().setName("Honda").setCreated(Instant.now());
        brandService.saveBrand(honda);
        BrandEntity scania = new BrandEntity().setName("Scania").setCreated(Instant.now());
        brandService.saveBrand(scania);
    }

//    private void initUsers() {
//        UserEntity admin = new UserEntity()
//                .setUsername("admin")
//                .setPassword(passwordEncoder.encode("topsecret"))
//                .setFirstName("Hristo")
//                .setLastName("Manov")
//                .setCreated(Instant.now())
//                .setRole(userRoleService.findRoleByName(UserRoleEnum.ADMIN));
//
//        userService.saveUser(admin);
//
//
//        UserEntity user = new UserEntity()
//                .setUsername("user")
//                .setPassword(passwordEncoder.encode("topsecret"))
//                .setFirstName("Ivan")
//                .setLastName("Ivanov")
//                .setCreated(Instant.now())
//                .setRole(userRoleService.findRoleByName(UserRoleEnum.USER));
//        userService.saveUser(user);
//    }
}
