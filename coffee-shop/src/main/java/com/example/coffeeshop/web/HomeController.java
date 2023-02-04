package com.example.coffeeshop.web;

import com.example.coffeeshop.model.view.OrderViewModel;
import com.example.coffeeshop.model.view.UserViewModel;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.UserService;
import com.example.coffeeshop.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (this.currentUser.getId() == null) {
            return "index";
        }

        List<OrderViewModel> orders = this.orderService.findAllOrdersOrderByPriceDesc();

        model.addAttribute("orders", orders);
        model.addAttribute("totalTime", orders
                .stream()
                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .reduce(Integer::sum)
                .orElse(0));

        List<UserViewModel> users = this.userService.findAllUserAndCountOfOrdersOrderByCountDesc();
        model.addAttribute("users", users);

        return "home";
    }


}
