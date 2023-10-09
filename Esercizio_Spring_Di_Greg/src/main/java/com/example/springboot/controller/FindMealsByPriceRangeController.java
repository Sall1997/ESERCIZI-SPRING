package com.example.springboot.controller;

import com.example.springboot.entity.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FindMealsByPriceRangeController {

    @GetMapping("/meal/price")
    public List<Meal> getMealsByPriceRange(@RequestParam(value = "min", required = false) Double minPrice,
            @RequestParam(value = "max", required = false) Double maxPrice){
        List<Meal>meals = new ArrayList<>();
        meals.add(new Meal("pasta col pesto", "pasta con pesto di basilico fresco",6, true));
        meals.add(new Meal("pasta col pomodoro", "pasta con pomodoro fresco",7, true));
        meals.add(new Meal("pasta con patate", "pasta con patate e salsiccia",8, true));

        List<Meal> filteredMeals = meals.stream()
                .filter(meal -> (minPrice == null || meal.getPrice() >= minPrice) &&
                        (maxPrice == null || meal.getPrice() <= maxPrice))
                .collect(Collectors.toList());

        return filteredMeals;
    }
}
