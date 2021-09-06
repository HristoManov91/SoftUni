package com.example.mobilelele.web;

import com.example.mobilelele.model.entity.Engine;
import com.example.mobilelele.model.entity.Transmission;
import com.example.mobilelele.model.service.OfferServiceModel;
import com.example.mobilelele.model.service.UserLoginServiceModel;
import com.example.mobilelele.service.BrandService;
import com.example.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OffersController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OffersController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("offerModel")
    public OfferServiceModel userModel(){
        return new OfferServiceModel();
    }

    @GetMapping("/add")
    public String newOffer(Model model){
        model.addAttribute("brands" , brandService.getAllBrands());
        model.addAttribute("engines" , Engine.values());
        model.addAttribute("transmissions" , Transmission.values());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid @ModelAttribute OfferServiceModel offerModel,
                           BindingResult bindingResult , RedirectAttributes redirectAttributes){
        offerService.save(offerModel);

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerModel" , offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);
            return "redirect:/offers/add";
        }

        return "redirect:/offers/all";
    }

    @GetMapping("/all")
    public String getAllOffers(Model offerModel){
        offerModel.addAttribute("models" , offerService.getAllOffers());
        return "offers";
    }
}
