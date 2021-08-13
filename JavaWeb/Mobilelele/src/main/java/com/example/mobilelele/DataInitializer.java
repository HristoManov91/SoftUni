package com.example.mobilelele;

import com.example.mobilelele.service.BrandService;
import com.example.mobilelele.service.ModelService;
import com.example.mobilelele.service.OfferService;
import com.example.mobilelele.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;
    private final OfferService offerService;

    public DataInitializer(BrandService brandService, ModelService modelService, UserService userService, OfferService offerService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.addBrand("Toyota" , Instant.now());
        brandService.addBrand("Audi", Instant.now());
        brandService.addBrand("Mercedes-Benz" , Instant.now());
        brandService.addBrand("Honda" , Instant.now());
        modelService.addModel("RS6" , Instant.now() , "car" , "https://audimediacenter-a.akamaihd.net/system/production/media/83014/images/b52bf0b68e1104a9e56fed9b28c2f84aa1445992/A1910897_blog.jpg?1582552359" , 1990 , 2L);
        modelService.addModel("RAV4" , Instant.now() , "car" , "https://autotrends.org/wp-content/uploads/2021/01/toyota-rav4-hybrid-2021-01.jpg" , 1995 , 1L);
        modelService.addModel("REBEL 1100" , Instant.now() , "motorcycle" , "https://powersports.honda.com/street/cruiser/rebel-1100/-/media/products/family/rebel-1100/trims/trim-main/rebel-1100/2021/2021-rebel-1100-bordeaux_red_metallic-650x380.png" , 2015 , 4L);
    }
}
