package com.example.bootcampexam.web;

import com.example.bootcampexam.model.binding.UserRegisterBindingModel;
import com.example.bootcampexam.model.service.UserRegisterServiceModel;
import com.example.bootcampexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
    public String login() {
        return "login";
    }

    @PostMapping("/login-error")
    public ModelAndView failedLogin(@ModelAttribute String email) {
        ModelAndView mvc = new ModelAndView();

        mvc.addObject("bad_credentials", true);
        mvc.addObject("email", email);

        mvc.setViewName("login");//ToDo

        return mvc;
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
            model.addAttribute("userExistError", false);
            model.addAttribute("equalsPassword", true);
        }
        return "register";
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        boolean usernameExist = userService.usernameExist(userRegisterBindingModel.getUsername());
        boolean emailExist = userService.emailExist(userRegisterBindingModel.getEmail());
        boolean equalsPassword = userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword());

        if (bindingResult.hasErrors() || !equalsPassword || emailExist || usernameExist) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            redirectAttributes.addFlashAttribute("equalsPassword", equalsPassword);
            redirectAttributes.addFlashAttribute("userExistError", emailExist);
            redirectAttributes.addFlashAttribute("usernameExist", usernameExist);
            return "redirect:register";
        }

        UserRegisterServiceModel userRegistrationServiceModel =
                modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class);

        userService.registerUser(userRegistrationServiceModel);

        return "redirect:login";
    }
}
