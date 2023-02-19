package com.resellerapp.service;

import com.resellerapp.model.entity.User;
import com.resellerapp.model.service.UserServiceModel;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    public void registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);
        this.userRepository.save(user);
    }

    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username, password)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    public void loginUser(Long id, String username) {
        this.currentUser.setId(id);
        this.currentUser.setUsername(username);
    }

    public User findById(Long id) {
        return this.userRepository
                .findById(id)
                .orElse(null);
    }


    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
