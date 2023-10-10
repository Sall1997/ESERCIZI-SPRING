package com.example.springboot.controller;

import com.example.springboot.entity.NewIngredient;
import com.example.springboot.service.NewIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/new-ingredients")
public class NewIngredientController {
    private final NewIngredientService newIngredientService;

    @Autowired
    public NewIngredientController(NewIngredientService newIngredientService) {
        this.newIngredientService = newIngredientService;
    }

    @GetMapping("/")
    public List<NewIngredient> getAllIngredients() {
        return newIngredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public Optional<NewIngredient> getIngredientById(@PathVariable Long id) {
        return newIngredientService.getIngredientById(id);
    }

    @PostMapping("/")
    public NewIngredient createIngredient(@RequestBody NewIngredient newIngredient) {
        return newIngredientService.createIngredient(newIngredient);
    }

    @PutMapping("/{id}")
    public NewIngredient updateNewIngredient(@PathVariable Long id, @RequestBody NewIngredient updatedNewIngredient ) {
        return newIngredientService.updateIngredient(id, updatedNewIngredient);
    }

    @DeleteMapping("/{id}")
    public void deleteNewIngredient(@PathVariable Long id) {
        newIngredientService.deleteIngredient(id);
    }
}
