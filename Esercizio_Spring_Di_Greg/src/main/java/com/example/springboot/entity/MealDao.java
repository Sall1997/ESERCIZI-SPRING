package com.example.springboot.entity;

import com.example.springboot.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MealDao extends JpaRepository<Meal, Long> {
    List<Meal> findByName(String name);
    List<Meal> findByPriceGreaterThanAndName(double price, String name);
    List<Meal> findByIsSummerMeal(boolean isSummerMeal);
    List<Meal> findByIsWinterMeal(boolean isWinterMeal);

}
