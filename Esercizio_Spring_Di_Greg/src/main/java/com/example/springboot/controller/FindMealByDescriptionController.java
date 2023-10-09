package com.example.springboot.controller;

import com.example.springboot.entity.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class FindMealByDescriptionController {

    @GetMapping("/meal/description-match/{phrase}")
    public List<Meal> findMealByName(@PathVariable String phrase){
        List<Meal>meals = new ArrayList<>();
        List<Meal>mealsByDescription = new ArrayList<>();
        meals.add(new Meal("pasta col pesto", "pasta con pesto di basilico fresco",6, true));
        meals.add(new Meal("pasta col pomodoro", "pasta con pomodoro fresco",6, true));
        meals.add(new Meal("pasta con patate", "pasta con patate e salsiccia",6, true));
        for (Meal meal : meals) {
            if(phrase.contains(meal.getDescription())){
                mealsByDescription.add(meal);
            }
        }
        return mealsByDescription;
    }
}
