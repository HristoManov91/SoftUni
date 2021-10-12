package com.example.mobilele.web;

import com.example.mobilele.model.binding.UserLoginBindingModel;
import com.example.mobilele.model.binding.UserRegisterBindingModel;
import com.example.mobilele.model.service.UserLoginServiceModel;
import com.example.mobilele.model.service.UserServiceModel;
import com.example.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

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
    public String loginConfirm(UserLoginBindingModel userLoginBindingModel){
        UserLoginServiceModel user = new UserLoginServiceModel()
                .setUsername(userLoginBindingModel.getUsername())
                .setRawPassword(userLoginBindingModel.getPassword());

        boolean loginSuccessful = userService.login(user);
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

        boolean usernameExist = userService.usernameExist(userRegisterBindingModel.getUsername());

        if(bindingResult.hasErrors() || usernameExist){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel" , userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel" ,
                    bindingResult);
            return "redirect:register";
        }

        UserServiceModel userServiceModel = modelMapper.map(userRegisterBindingModel , UserServiceModel.class);

        userService.saveUser(userServiceModel);

        return "redirect:login";
    }
}
