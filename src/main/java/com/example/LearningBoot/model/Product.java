package com.example.LearningBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size; 

@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Name is mandatory", groups = {Product.class})
    @Size(min = 2 , max = 100 , message="Name must be between 2 to 100 character length")
    private String name;

    @Min(value = 0 , message = "price cant be less than 0")
    private double price;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    @JsonBackReference
    private Category category;

    public Product(){}

    public Product(String name, double price, Category category){
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
