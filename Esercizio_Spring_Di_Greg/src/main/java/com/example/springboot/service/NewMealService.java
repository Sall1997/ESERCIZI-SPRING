package com.example.springboot.service;

import com.example.springboot.entity.Meal;
import com.example.springboot.entity.NewMealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewMealService {
    private NewMealDao newMealDao;

    @Autowired
    public NewMealService(NewMealDao newMealDao) {
        this.newMealDao = newMealDao;
    }

    public void addMeal(Meal meal){
        if(meal == null) throw new IllegalArgumentException("Meal cannot be null!");
        if(meal.getName() == null || meal.getName().isEmpty()) throw new IllegalArgumentException("Meal name cannot be null or empty!");
        if(meal.getDescription() == null || meal.getDescription().isEmpty()) throw new IllegalArgumentException("Meal description cannot be null or empty!");
        if(meal.getPrice() <= 0) throw new IllegalArgumentException("Meal price cannot be less than or equal to 0!");
        if(meal.getPrice() > 0) throw new IllegalArgumentException("Meal price cannot be grater than 100!");
        newMealDao.addMeal(meal);
    }
    public void deleteMeal(String mealName){
        newMealDao.deleteMeal(mealName);
    }

    public void updateMeal(Meal meal){
        newMealDao.updateMeal(meal);
    }

    public List<Meal> getMeals() {
        return newMealDao.getMeals();
    }
}
