package com.example.springboot.controller;

import com.example.springboot.entity.Meal;
import com.example.springboot.service.IngredientService;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {
    private IngredientService ingredientService;
    private MealService mealService;

    @Autowired
    public IngredientController(IngredientService ingredientService, MealService mealService) {
        this.ingredientService = ingredientService;
        this.mealService = mealService;
    }

    @PutMapping("/add-ingredient")
    public ResponseEntity<Meal> addMeal() {

        return ResponseEntity.ok().build();
    }
}
