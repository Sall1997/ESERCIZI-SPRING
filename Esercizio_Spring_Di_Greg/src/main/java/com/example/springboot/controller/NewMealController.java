package com.example.springboot.controller;

import com.example.springboot.entity.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewMealController {

    @GetMapping("/meals")
    public List<Meal>getMeals(){
        List<Meal>meals = new ArrayList<>();
        meals.add(new Meal("pasta col pesto", "pasta con pesto di basilico fresco",6, true));
        meals.add(new Meal("pasta col pomodoro", "pasta con pomodoro fresco",6, true));
        meals.add(new Meal("pasta con patate", "pasta con patate e salsiccia",6, true));
        return meals;
    }
}