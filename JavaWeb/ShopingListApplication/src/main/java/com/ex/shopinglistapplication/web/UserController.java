package com.ex.shopinglistapplication.web;

import com.ex.shopinglistapplication.model.binding.UserLoginBindingModel;
import com.ex.shopinglistapplication.model.binding.UserRegisterBindingModel;
import com.ex.shopinglistapplication.model.service.UserServiceModel;
import com.ex.shopinglistapplication.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("bindingModel")) {
            model.addAttribute("bindingModel", new UserRegisterBindingModel());
            model.addAttribute("isExists" , false);
        }
        return "/register";
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        boolean equalsPassword = userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword());
        if (bindingResult.hasErrors() || !equalsPassword) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        Boolean isSaved = userService.register(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        if(!isSaved){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel" , userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("isExists" , true);

            return "redirect:register";
        }

        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("notFound", false);
        }
        return "/login";
    }

    @PostMapping("/login")
    public String confirmLogin(@Valid UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.
                    addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);
            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService.findByUsernameAndPassword(
                userLoginBindingModel.getUsername(),
                userLoginBindingModel.getPassword());

        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }

        httpSession.setAttribute("user", userServiceModel);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();

        return "redirect:/";
    }
}
