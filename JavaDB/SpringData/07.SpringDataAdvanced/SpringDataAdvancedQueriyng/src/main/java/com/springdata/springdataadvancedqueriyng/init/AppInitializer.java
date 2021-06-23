package com.springdata.springdataadvancedqueriyng.init;

import com.springdata.springdataadvancedqueriyng.dao.IngredientRepository;
import com.springdata.springdataadvancedqueriyng.dao.LabelRepository;
import com.springdata.springdataadvancedqueriyng.dao.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.springdata.springdataadvancedqueriyng.entity.Size.MEDIUM;

@Component
public class AppInitializer implements CommandLineRunner {
    private final ShampooRepository shampooRepo;
    private final LabelRepository labelRepo;
    private final IngredientRepository ingredientRepo;

    @Autowired
    public AppInitializer(ShampooRepository shampooRepo, LabelRepository labelRepo, IngredientRepository ingredientRepo) {
        this.shampooRepo = shampooRepo;
        this.labelRepo = labelRepo;
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        shampooRepo.findBySizeOrderById(MEDIUM).forEach(System.out::println);
    }
}
