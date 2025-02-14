package com.example.LearningBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LearningBoot.model.Category;
import com.example.LearningBoot.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public void saveCategory(Category category){
        categoryRepository.save(category);
    }
}
