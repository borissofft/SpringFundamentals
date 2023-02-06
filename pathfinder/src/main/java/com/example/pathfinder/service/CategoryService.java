package com.example.pathfinder.service;


import com.example.pathfinder.model.entity.Category;
import com.example.pathfinder.model.enums.CategoryName;

public interface CategoryService {
    Category findCategoryByName(CategoryName categoryName);

}
