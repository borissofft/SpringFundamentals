package bg.softuni.springmvc.web;

import bg.softuni.springmvc.model.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String newUser() {
        return "newuser";
    }

    @PostMapping
    public String createUser(UserDto userDto) { // Spring make automatic mapping from our form in newuser.html(name="fname, name="lname") to UserDto Object (fname/lname)
        System.out.println("Creating new user... " + userDto);
        return "usercreated";
    }

}






