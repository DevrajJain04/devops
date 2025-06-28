package com.example.LearningBoot.service;

import com.example.LearningBoot.repository.ProductRepository;
import com.example.LearningBoot.model.Product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    // Save Product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    //delete Product
    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }
    public List<Product> getProductsByCategory(Long id) {
        List<Product> products = getAllProducts();
        for(Product product : products){
            if (product.getCategory().getId() != id){
                products.remove(product);
            }
        }
        return products;
    }
}
