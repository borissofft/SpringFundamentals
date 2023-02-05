package com.example.pathfinder.web;

import com.example.pathfinder.model.view.RouteViewModel;
import com.example.pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;


    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {
        List<RouteViewModel> routesViewList = this.routeService.findAllRoutesView();
        model.addAttribute("routes", routesViewList);
        return "routes";
    }



}
