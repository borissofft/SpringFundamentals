package com.resellerapp.controller;

import com.resellerapp.model.binding.OfferAddBindingModel;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.service.OfferService;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public OfferController(OfferService offerService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    OfferAddBindingModel offerAddBindingModel() {
        return new OfferAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {

        if (this.currentUser.getId() == null) {
            return "index";
        }

        return "offer-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid OfferAddBindingModel offerAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("offerAddBindingModel", offerAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel",
                            bindingResult);

            return "redirect:add";
        }

        this.offerService.addOffer(this.modelMapper
                .map(offerAddBindingModel, OfferServiceModel.class));

        return "redirect:/";
    }

}
