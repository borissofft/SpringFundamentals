package com.softuni.battleships.service;

import com.softuni.battleships.model.entity.Category;
import com.softuni.battleships.model.enums.CategoryEnum;
import com.softuni.battleships.repository.CategoryRepository;
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

        Arrays.stream(CategoryEnum.values())
                .forEach(categoryEnum -> {
                    Category category = new Category();
                    category.setName(categoryEnum);
                    switch (categoryEnum) {
                        case BATTLE -> category.setDescription("Battle Ship");
                        case CARGO -> category.setDescription("Cargo Ship");
                        case PATROL -> category.setDescription("Patrol Ship");
                    }

                    this.categoryRepository.save(category);
                });
    }

}
