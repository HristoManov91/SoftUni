package com.example.mobilele.web;

import com.example.mobilele.model.entity.enums.EngineEnum;
import com.example.mobilele.model.entity.enums.TransmissionEnum;
import com.example.mobilele.model.binding.OfferUpdateBindingModel;
import com.example.mobilele.model.service.OfferUpdateServiceModel;
import com.example.mobilele.model.view.OfferDetailsView;
import com.example.mobilele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OffersController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String allOffers(Model model){
        model.addAttribute("offers" , offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/{id}/details")
    public String showOffer(@PathVariable Long id , Model model){
        model.addAttribute("offer" , this.offerService.findById(id));
        return "details";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        offerService.deleteOffer(id);
        return "redirect:all";
    }

    @GetMapping("/{id}/edit")
    public String editOffer(@PathVariable Long id , Model model){

        OfferDetailsView offerDetailsView = offerService.findById(id);
        OfferUpdateBindingModel offerModel = modelMapper.map(offerDetailsView , OfferUpdateBindingModel.class);

        model.addAttribute("engines" , EngineEnum.values());
        model.addAttribute("transmission" , TransmissionEnum.values());
        model.addAttribute("offerModel" , offerModel);

        return "update";
    }

    @GetMapping("/{id}/edit/erros")
    public String editOfferErrors(@PathVariable Long id , Model model){

        model.addAttribute("engines" , EngineEnum.values());
        model.addAttribute("transmission" , TransmissionEnum.values());

        return "update";
    }

    @PatchMapping("/{id}/edit")
    public String editOffer(@PathVariable Long id ,
                            OfferUpdateBindingModel offerModel ,
                            BindingResult bindingResult ,
                            RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerModel",
                            bindingResult);

            return "redirect:/offers/" + id + "/edit/errors";
        }

        OfferUpdateServiceModel serviceModel = modelMapper.map(offerModel , OfferUpdateServiceModel.class);
        serviceModel.setId(id);

        offerService.updateOffer(serviceModel);

        return "redirect:/" + id + "/details";
    }
}
