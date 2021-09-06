package com.example.mobilelele.web;

import com.example.mobilelele.model.entity.Model;
import com.example.mobilelele.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandsController {

    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String allBrands(Model model){
//        model.addAtribute("brands" , brandService.getAllBrands());
        return "brands";
    }
}
