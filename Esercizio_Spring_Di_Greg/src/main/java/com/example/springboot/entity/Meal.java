package com.example.springboot.entity;

import com.example.springboot.entity.Ingredient;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private double price;
    private boolean isWinterMeal;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

    public Meal(String name, String description, double price, boolean isWinterMeal) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isWinterMeal = isWinterMeal;

    }

    public Meal() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isWinterMeal() {
        return isWinterMeal;
    }

    public void setWinterMeal(boolean isWinterMeal) {
        this.isWinterMeal = isWinterMeal;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price;
    }
}
