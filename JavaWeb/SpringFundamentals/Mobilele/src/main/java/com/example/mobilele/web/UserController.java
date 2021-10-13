package com.example.mobilele.web;

import com.example.mobilele.model.binding.UserLoginBindingModel;
import com.example.mobilele.model.binding.UserRegisterBindingModel;
import com.example.mobilele.model.service.UserLoginServiceModel;
import com.example.mobilele.model.service.UserRegisterServiceModel;
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

    @ModelAttribute("userModel")
    public UserRegisterBindingModel userModel(){
        return new UserRegisterBindingModel();
    }

    // ----- Login -----
    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserRegisterServiceModel());
            model.addAttribute("notFound", false);
        }
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginBindingModel userLoginBindingModel) {
        UserLoginServiceModel user = new UserLoginServiceModel()
                .setUsername(userLoginBindingModel.getUsername())
                .setRawPassword(userLoginBindingModel.getPassword());

        boolean loginSuccessful = userService.login(user);

        LOGGER.info("User tried to login. User with name {} tried to login. Success = {}?",
                userLoginBindingModel.getUsername(),
                loginSuccessful);

        if (loginSuccessful) {
            return "redirect:/";
        }

        return "redirect:login";
    }

    // ----- Register -----
    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        boolean usernameExist = userService.usernameExist(userModel.getUsername());
        boolean equalsPasswords = userModel.getPassword().equals(userModel.getConfirmPassword());

        if (bindingResult.hasErrors() || usernameExist || !equalsPasswords) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            return "redirect:register";
        }

        UserRegisterServiceModel serviceModel = modelMapper.map(userModel, UserRegisterServiceModel.class);

        userService.registerAndLoginUser(serviceModel);

        return "redirect:/";
    }

    // ----- Logout -----
    @GetMapping("logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }
}
