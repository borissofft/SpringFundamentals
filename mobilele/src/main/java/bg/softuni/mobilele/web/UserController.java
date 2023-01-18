package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/logout")
    public String logout() {
        this.userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto) {
        this.userService.login(userLoginDto);
        return "redirect:/";
    }

    @GetMapping("register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("register")
    public String register(UserRegisterDto userRegisterDto) {
        this.userService.registerAndLogin(userRegisterDto);
        return "redirect:/";
    }

    // TODO: Explain POST-redirect-GET

}

// 0:20:00