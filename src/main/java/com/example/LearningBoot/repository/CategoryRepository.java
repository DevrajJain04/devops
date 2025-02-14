package com.example.LearningBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.LearningBoot.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}
