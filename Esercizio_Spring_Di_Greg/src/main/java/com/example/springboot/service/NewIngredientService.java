package com.example.springboot.service;

import com.example.springboot.entity.Ingredient;
import com.example.springboot.entity.NewIngredient;
import com.example.springboot.entity.NewIngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewIngredientService {
    private final NewIngredientDao newIngredientDao;

    public NewIngredientService(NewIngredientDao newIngredientDao) {
        this.newIngredientDao = newIngredientDao;
    }

    @Autowired
    public List<NewIngredient> getAllIngredients() {
        return newIngredientDao.findAll();
    }

    public Optional<NewIngredient> getIngredientById(Long id) {
        return newIngredientDao.findById(id);
    }

    public NewIngredient createIngredient(NewIngredient newIngredient) {
        return newIngredientDao.save(newIngredient);
    }

    public NewIngredient updateIngredient(Long id, NewIngredient updatedNewIngredient) {
        if (newIngredientDao.existsById(id)) {
            updatedNewIngredient.setId(id);
            return newIngredientDao.save(updatedNewIngredient);
        } else {
            throw new IllegalArgumentException("Ingrediente non trovato");
        }
    }

    public void deleteIngredient(Long id) {
        newIngredientDao.deleteById(id);
    }
}
