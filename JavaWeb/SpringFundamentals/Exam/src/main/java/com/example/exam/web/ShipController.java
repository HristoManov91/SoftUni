package com.example.exam.web;

import com.example.exam.model.binding.ShipAddBindingModel;
import com.example.exam.model.service.ShipServiceModel;
import com.example.exam.model.service.UserServiceModel;
import com.example.exam.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public ShipController(ShipService shipService, ModelMapper modelMapper, HttpSession httpSession) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String addShip(Model model , HttpSession httpSession){
        if(httpSession.getAttribute("user") == null){
            return "redirect:/users/login";
        }

        if (!model.containsAttribute("shipAddBindingModel")){
            model.addAttribute("shipAddBindingModel", new ShipAddBindingModel());
        }
        return "ship-add";
    }

    @PostMapping("/add")
    public String addShipConfirm(@Valid ShipAddBindingModel shipAddBindingModel ,
                                 BindingResult bindingResult , RedirectAttributes redirectAttributes ,
                                 HttpSession httpSession){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel",
                    bindingResult);

            return "redirect:add";
        }

        ShipServiceModel shipServiceModel = modelMapper.map(shipAddBindingModel , ShipServiceModel.class);
        shipService.addShip(shipServiceModel);

        return "redirect:/";
    }
}
