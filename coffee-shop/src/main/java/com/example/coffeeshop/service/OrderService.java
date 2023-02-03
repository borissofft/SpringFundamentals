package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.Order;
import com.example.coffeeshop.model.service.OrderServiceModel;
import com.example.coffeeshop.repository.OrderRepository;
import com.example.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = this.modelMapper.map(orderServiceModel, Order.class);
        order.setEmployee(this.userService.findById(this.currentUser.getId()));
        order.setCategory(this.categoryService.findByCategoryName(orderServiceModel.getCategory()));
        this.orderRepository.save(order);
    }
}
