package com.example.pathfinder.web;

import com.example.pathfinder.model.binding.RouteAddBindingModel;
import com.example.pathfinder.model.service.RouteServiceModel;
import com.example.pathfinder.model.view.RouteViewModel;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;


    @Autowired
    public RouteController(RouteService routeService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    RouteAddBindingModel routeAddBindingModel() {
        return new RouteAddBindingModel();
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {
        List<RouteViewModel> routesViewList = this.routeService.findAllRoutesView();
        model.addAttribute("routes", routesViewList);
        return "routes";
    }

    @GetMapping("/add")
    public String add() {
        if (this.currentUser.getId() == null) {
            return "redirect:/users/login";
        }
        return "add-route";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid RouteAddBindingModel routeAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("routeAddBindingModel", routeAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel",
                            bindingResult);

            return "redirect:add";
        }

        RouteServiceModel routeServiceModel = this.modelMapper
                .map(routeAddBindingModel, RouteServiceModel.class);
        routeServiceModel.setGpxCoordinates(new String(routeAddBindingModel.getGpxCoordinates().getBytes()));

        return "redirect:all";
    }

}
