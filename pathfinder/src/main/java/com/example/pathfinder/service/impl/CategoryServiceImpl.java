package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Category;
import com.example.pathfinder.model.enums.CategoryName;
import com.example.pathfinder.repository.CategoryRepository;
import com.example.pathfinder.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category findCategoryByName(CategoryName categoryName) {
        return this.categoryRepository
                .findByName(categoryName)
                .orElse(null);
    }
}
