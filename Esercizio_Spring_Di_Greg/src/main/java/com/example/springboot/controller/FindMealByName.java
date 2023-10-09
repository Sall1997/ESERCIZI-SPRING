package com.example.springboot.controller;

import com.example.springboot.entity.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FindMealByName {

    @GetMapping("/meal/{name}")
    public List<Meal> findMealByName(@PathVariable String name){
        List<Meal>meals = new ArrayList<>();
        List<Meal>mealsByName = new ArrayList<>();
        meals.add(new Meal("pasta col pesto", "pasta con pesto di basilico fresco",6, true));
        meals.add(new Meal("pasta col pomodoro", "pasta con pomodoro fresco",6, true));
        meals.add(new Meal("pasta con patate", "pasta con patate e salsiccia",6, true));
        for (Meal meal : meals) {
            if(name.contains(meal.getName())){
                mealsByName.add(meal);
            }
        }
        return mealsByName;
    }
}
