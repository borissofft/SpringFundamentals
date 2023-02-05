package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.service.RouteServiceModel;
import com.example.pathfinder.model.view.RouteViewModel;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.CategoryService;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RouteViewModel> findAllRoutesView() {
        return this.routeRepository.findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel = this.modelMapper.map(route, RouteViewModel.class);
//                    if (route.getPictures().isEmpty()) {
//                        routeViewModel.setPictureUrl("/images/pic4.jpg");
//                    } else {
//                        routeViewModel.setPictureUrl(route.getPictures().stream().findFirst().get().getUrl());
//                    }
                    routeViewModel.setPictureUrl(route.getPictures().isEmpty() ? "/images/pic4.jpg" : route.getPictures().stream().findAny().get().getUrl());
                    return routeViewModel;
                })
                .toList();
    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {
        Route route = this.modelMapper.map(routeServiceModel, Route.class);
        User user = this.userService.findCurrentLoginUserEntity();
        route.setAuthor(user);


        this.routeRepository.save(route);
    }
}

// 2:20:57