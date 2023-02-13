package com.softuni.battleships.web;

import com.softuni.battleships.model.binding.ShipAddBindingModel;
import com.softuni.battleships.repository.ShipRepository;
import jakarta.validation.Valid;
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
    private final ShipRepository shipRepository;

    @Autowired
    public ShipController(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @ModelAttribute
    ShipAddBindingModel shipAddBindingModel() {
        return new ShipAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {
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



        return "redirect:/";
    }

}
