package com.softuni.battleships.service;

import com.softuni.battleships.model.entity.Ship;
import com.softuni.battleships.model.service.ShipServiceModel;
import com.softuni.battleships.repository.ShipRepository;
import com.softuni.battleships.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;


    @Autowired
    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper, CurrentUser currentUser
            , UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    public void addShip(ShipServiceModel shipServiceModel) {

        Ship ship = this.modelMapper.map(shipServiceModel, Ship.class);
        ship.setUser(this.userService.findById(this.currentUser.getId()));
        ship.setCategory(this.categoryService.findByCategoryName(shipServiceModel.getCategory()));
        this.shipRepository.save(ship);

    }
}
