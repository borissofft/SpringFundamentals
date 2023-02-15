package com.softuni.battleships.web;

import com.softuni.battleships.model.binding.ShipAddBindingModel;
import com.softuni.battleships.model.service.ShipServiceModel;
import com.softuni.battleships.service.ShipService;
import com.softuni.battleships.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ships")
public class ShipController {
    private final ShipService shipService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    @Autowired
    public ShipController(ShipService shipService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    ShipAddBindingModel shipAddBindingModel() {
        return new ShipAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {

        if (this.currentUser.getId() == null) {
            return "index";
        }

        return "ship-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("shipAddBindingModel", shipAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel",
                            bindingResult);

            return "redirect:add";
        }


        this.shipService.addShip(this.modelMapper
                .map(shipAddBindingModel, ShipServiceModel.class));

        return "redirect:/";
    }

}
