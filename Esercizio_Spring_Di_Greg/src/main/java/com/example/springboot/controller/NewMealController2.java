package com.example.springboot.controller;

import com.example.springboot.entity.Meal;
import com.example.springboot.service.MealService;
import com.example.springboot.service.NewMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewMealController2 {
    private NewMealService newMealService;

    @Autowired
    public NewMealController2(NewMealService newMealService) {
        this.newMealService = newMealService;
    }

    @GetMapping(value = "/get/meals")
    public ResponseEntity<List<Meal>>getMeals(){
        return ResponseEntity.ok(newMealService.getMeals());
    }
    @PutMapping(value = "/put/meal")
    public ResponseEntity<String>putMeal(@RequestBody Meal meal){
        try {
            newMealService.addMeal(meal);
            return ResponseEntity.ok("Meal addead!");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/meal/{mealName}")
    public ResponseEntity<String>deleteMeal(@PathVariable String mealName){
        newMealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal deleted");
    }

    @PostMapping(value = "/post/replace-meal")
    public ResponseEntity<String>postMeal(@RequestBody Meal meal){
        newMealService.updateMeal(meal);
        newMealService.addMeal(meal);
        return ResponseEntity.ok("Meal updated");
    }
}
