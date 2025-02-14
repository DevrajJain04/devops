package com.example.LearningBoot.repository;

import com.example.LearningBoot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
