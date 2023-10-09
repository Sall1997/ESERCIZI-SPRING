package com.example.springboot.service;

import com.example.springboot.entity.IngredientDao;
import com.example.springboot.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService  {
    private IngredientDao ingredientDao;

    @Autowired
    public IngredientService(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void addIngredient(Ingredient dumpling) {
        ingredientDao.save(dumpling);
    }
}
