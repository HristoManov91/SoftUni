package com.example.exam.web;

import com.example.exam.model.binding.ShipBattleBindingModel;
import com.example.exam.model.service.ShipBattleServiceModel;
import com.example.exam.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    private final ShipService shipService;

    public HomeController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){

        model.addAttribute("attackerShips" , shipService.findAllShipFromLoggetUser());
        model.addAttribute("defenderShips" , shipService.findAllShipWithoutLoginUser());
        model.addAttribute("allShips" , shipService.findAllShipsOrderByIdAndStatus());

        return "home";
    }

    @PostMapping("/home")
    public String fire(@Valid ShipBattleBindingModel shipBattleBindingModel,
                       BindingResult bindingResult , RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("shipBattleBindingModel" , shipBattleBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipBattleBindingModel",
                    bindingResult);

            return "redirect:/home";
        }

        shipService.attack(shipBattleBindingModel.getAttackerShipId(), shipBattleBindingModel.getDefenderShipId());
        return "redirect:/home";
    }

    @ModelAttribute
    public ShipBattleBindingModel shipBattleBindingModel() {
        return new ShipBattleBindingModel();
    }
}
