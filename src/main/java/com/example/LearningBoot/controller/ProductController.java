package com.example.LearningBoot.controller;

import com.example.LearningBoot.model.Product;
import com.example.LearningBoot.service.ProductService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/category/{id}")
    public List<Product> getProductsByCategory(@PathVariable Long id){
        return productService.getProductsByCategory(id);
    }

    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product) {
        if (product.getCategory() == null) {
            throw new RuntimeException("Category is required");
        }
        return productService.saveProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        product.setId(id);
        return productService.saveProduct(product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
