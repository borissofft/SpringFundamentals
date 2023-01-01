package bg.softuni.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// MVC: Model-View-Controller

@Controller
public class HelloController {  // Controller

    // Variant 1: Model
    @GetMapping("/hello")
    public String hello(Model model) {  // Model
        model.addAttribute("num", 3); // pass this name and value parameters to Thymeleaf template in helloworld.html View
        return "helloworld"; // View
    }

// Variant 2: ModelMap
//    @GetMapping("/hello")
//    public String hello(ModelMap model) {
//        model.put("num", 3);
//        return "helloworld";
//    }

// Variant 3: ModelAndView
//    @GetMapping("/hello")
//    public ModelAndView hello(ModelAndView modelAndView) {
//        modelAndView.addObject("num", 3);
//        modelAndView.setViewName("helloworld");
//        return modelAndView;
//    }

// Variant 4: Model
//    @GetMapping("/hello")
//    public String hello(Model model, @RequestParam("num") Integer num) {
//        model.addAttribute("num", num); // Example http://localhost:8080/hello?num=54 - this way you pass the number
//        return "helloworld";
//    }

    // Variant 5: Model
    @GetMapping("/hello/{id}/test")
    public String hello(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("num", id); // Example http://localhost:8080/hello/44/test
        return "helloworld";
    }

}

