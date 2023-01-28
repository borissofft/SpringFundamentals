package com.example.pathfinder.web;

import com.example.pathfinder.model.binding.UserRegisterBindingModel;
import com.example.pathfinder.model.service.UserServiceModel;
import com.example.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    // Variant 2
    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/register")
    public String register(Model model) {
        // Variant 1
//        if (!model.containsAttribute("userRegisterBindingModel")) { // If this comes from frontend for the first time
//            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel()); // Get this empty model to use it in fronted to avoid exceptions
//        }

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel, // Validate BindingModel. After this class always have to be BindingResult
                                  BindingResult bindingResult,                              // Get errors after validation if exist
                                  RedirectAttributes redirectAttributes) {                  // Save the result from UserRegisterBindingModel

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);
            return "redirect:register"; // register is the name of the method! We have populated valid data(in the form) because of using th:field="" in register.html
        }

        this.userService.registerUser(this.modelMapper
                .map(userRegisterBindingModel, UserServiceModel.class));


        return "redirect:login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}

//1:52:00