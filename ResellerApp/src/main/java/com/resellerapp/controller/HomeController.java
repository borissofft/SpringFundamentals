package com.resellerapp.controller;

import com.resellerapp.model.entity.User;
import com.resellerapp.model.view.OfferViewModel;
import com.resellerapp.service.HomeService;
import com.resellerapp.service.UserService;
import com.resellerapp.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    private final HomeService homeService;
    private final CurrentUser currentUser;

    private final UserService userService;

    @Autowired
    public HomeController(HomeService homeService, CurrentUser currentUser, UserService userService) {
        this.homeService = homeService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {

        if (this.currentUser.getId() == null) {
            return "index";
        }

        List<OfferViewModel> currentUserOffers = this.homeService.findAllOffersOfCurrentUser(this.currentUser.getId());
        List<OfferViewModel> allOffers = this.homeService.findAllOffers();
        long totalOffers = allOffers.size();
        List<User> users = this.userService.findAll();

        model.addAttribute("currentUserOffers", currentUserOffers);
        model.addAttribute("allOffers", allOffers);
        model.addAttribute("totalOffers", totalOffers);
        model.addAttribute("users", users);

        return "home";
    }

    @GetMapping("/home/remove-offer/{id}")
    public String removeOffer(@PathVariable Long id) {
        this.homeService.deleteCurrentOffer(id);
        return "redirect:/";
    }

}
