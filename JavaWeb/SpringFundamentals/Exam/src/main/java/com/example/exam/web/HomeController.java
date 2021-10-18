package com.example.exam.web;

import com.example.exam.model.binding.ShipBattleBindingModel;
import com.example.exam.model.service.ShipBattleServiceModel;
import com.example.exam.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;

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
        if (model.containsAttribute("shipBattleBindingModel")){
            model.addAttribute("shipBattleBindingModel" , new ShipBattleBindingModel());
        }
        model.addAttribute("attackerShips" , shipService.findAllShipFromLoggetUser());
        model.addAttribute("defenderShips" , shipService.findAllShipWithoutLoginUser());
        model.addAttribute("allShips" , shipService.findAllShipsOrderByIdAndStatus());

//        shipService.attack(shipBattleBindingModel.getAttackerName() , shipBattleBindingModel.getDefenderName());
        return "home";
    }

    @PostMapping("/home/fire")
    public String fire(ShipBattleBindingModel shipBattleBindingModel){

//        shipService.attack(ShipBattleServiceModel attacker , ShipBattleServiceModel defender);
        return "redirect:home";
    }
}
