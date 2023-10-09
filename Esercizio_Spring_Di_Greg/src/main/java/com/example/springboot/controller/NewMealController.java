package com.example.springboot.controller;

import com.example.springboot.entity.Meal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewMealController {
    List<Meal>meals= new ArrayList<>();

    @GetMapping("/meals")
    public List<Meal>getMeals(){
        List<Meal>meals = new ArrayList<>();
        meals.add(new Meal("pasta col pesto", "pasta con pesto di basilico fresco",6, true));
        meals.add(new Meal("pasta col pomodoro", "pasta con pomodoro fresco",6, true));
        meals.add(new Meal("pasta con patate", "pasta con patate e salsiccia",6, true));
        return meals;
    }

    @PostMapping("/meal")
    public Meal addMeal(@RequestBody Meal meal){
        this.meals.add(meal);

        return meal;
    }

    @PostMapping("/meal/{name}")
    public Meal modifyName(@PathVariable String name, @RequestBody Meal updatedMeal){
        for (Meal meal : this.meals) {
            if(meal.getName().equals(name)){
                meal.setName(name);
                return meal;
            }
        }
        return null;
    }
    @DeleteMapping("/meal/{name}")
    public Meal deleteMealeByName(@PathVariable String name){

        for (Meal mealRemoved : this.meals) {
            if(mealRemoved.getName().equals(name)){
                meals.remove(mealRemoved);
                return mealRemoved;
            }
        }
        return null;
    }
}
