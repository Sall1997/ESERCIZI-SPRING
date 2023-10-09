package com.example.springboot.entity;

import com.example.springboot.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDao extends JpaRepository<Ingredient, Long> {}
