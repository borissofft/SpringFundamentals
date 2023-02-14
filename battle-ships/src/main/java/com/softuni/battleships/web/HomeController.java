package com.softuni.battleships.web;

import com.softuni.battleships.model.view.ShipViewModel;
import com.softuni.battleships.service.ShipService;
import com.softuni.battleships.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;
    private final CurrentUser currentUser;

    @Autowired
    public HomeController(ShipService shipService, CurrentUser currentUser) {
        this.shipService = shipService;
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String index(Model model) {

        if (this.currentUser.getId() == null) {
            return "index";
        }

        List<ShipViewModel> currentUserShips = this.shipService.findAllShipsOfCurrentUser(this.currentUser.getId());
        List<ShipViewModel> otherUsersShips = this.shipService.findAllOtherShips(this.currentUser.getId());

        model.addAttribute("currentUserShips", currentUserShips);
        model.addAttribute("otherUsersShips", otherUsersShips);

        return "home";
    }


    @ModelAttribute(name = "allShips")
    public List<ShipViewModel> ships() {
        if (this.currentUser.getId() == null) {
            return List.of();
        }
        return this.shipService.findAll();
    }

}
