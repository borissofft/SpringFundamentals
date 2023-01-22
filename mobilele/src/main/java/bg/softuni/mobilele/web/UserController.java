package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto) {
        this.userService.login(userLoginDto);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        this.userService.logout();
        return "redirect:/";
    }

    @GetMapping("register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("register")
    public String register(@Valid UserRegisterDto userRegisterDto,
                           BindingResult bindingResult) { // allows us to handle the error rather than print out all the error message on the endpoint: /users/register

        if (bindingResult.hasErrors()) {
            return "redirect:/users/register";
        }

        this.userService.registerAndLogin(userRegisterDto);
        return "redirect:/";
    }

    // TODO: Explain POST-redirect-GET

}

// 1:17:00