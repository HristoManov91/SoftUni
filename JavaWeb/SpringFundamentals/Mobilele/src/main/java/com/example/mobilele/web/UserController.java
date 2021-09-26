package com.example.mobilele.web;

import com.example.mobilele.model.binding.UserLoginBindingModel;
import com.example.mobilele.model.binding.UserRegisterBindingModel;
import com.example.mobilele.model.service.UserServiceModel;
import com.example.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(Model model){
        if(!model.containsAttribute("userLoginBindingModel")){
            model.addAttribute("userLoginBindingModel" , new UserServiceModel());
            model.addAttribute("notFound" , false);
        }
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult , RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBindingModel" , userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel" , bindingResult);

            return "redirect:/login";
        }

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model){
        if(!model.containsAttribute("userRegisterBindingModel")){
            model.addAttribute("userRegisterBindingModel" , new UserRegisterBindingModel());
        }
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel" , userRegisterBindingModel);
            return "redirect:register";
        }

        //ToDo да запазя юзер в базата

        return "redirect:login";
    }
}
