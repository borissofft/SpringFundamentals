package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.enums.Level;
import com.example.pathfinder.model.service.UserServiceModel;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);
        user.setLevel(Level.BEGINNER);
        this.userRepository.save(user);
    }
}
