package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.enums.CategoryName;
import com.example.coffeeshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initCategories() {
        if (this.categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryName.values())
                .forEach(categoryName -> {
                    Category category = new Category();
                    category.setName(categoryName);
                    switch (categoryName) {
                        case Drink -> category.setNeededTime(1);
                        case Coffee -> category.setNeededTime(2);
                        case Other -> category.setNeededTime(5);
                        case Cake -> category.setNeededTime(10);
                    }

                    this.categoryRepository.save(category);
                });

    }

    public Category findByCategoryName(CategoryName categoryName) {
        return this.categoryRepository
                .findByName(categoryName)
                .orElse(null);
    }
}