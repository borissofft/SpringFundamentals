package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.service.UserService;
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
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public void initUserModel(Model model) {
        model.addAttribute("userModel", new UserRegisterDto());
    }

    // @ModelAttribute -> When executed @GetMapping we will have one userModel which will be empty and can be used in the form "auth-register"

    @GetMapping("register")
    public String register() {
        return "auth-register";
    }

    // TODO: Explain POST-redirect-GET
    @PostMapping("register")
    public String register(@Valid UserRegisterDto userModel, // @Valid DTO enables validations from DTO(Model). Immediately after it there must be BindingResult if we what to use binding results
                           BindingResult bindingResult, // allows us to handle the error rather than print out all the error message on the endpoint: /users/register
                           RedirectAttributes redirectAttributes) { // give us a chance to add some attributes when we make redirect

       // Flash attributes will be accessible after redirect in file: auth-register.html
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult); // can get BindingResult which can be used to underline some errors(see th:errorclass="is-invalid" in auth-register.html)
            return "redirect:/users/register";
        }

        this.userService.registerAndLogin(userModel);
        return "redirect:/";
    }

}
