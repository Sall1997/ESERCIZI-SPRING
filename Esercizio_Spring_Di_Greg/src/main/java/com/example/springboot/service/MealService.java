package com.example.springboot.service;

import com.example.springboot.entity.Meal;
import com.example.springboot.entity.MealDao;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {
    private MealDao mealDao;
    private Double MAX_WINTER_TEMP = 20.0;

    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public void addMeal(Meal meal) {
        mealDao.save(meal);
    }

    public List<Meal> getMeals() {
        return mealDao.findAll();
    }

    public void deleteMeal(long id) {
        mealDao.deleteById(id);
    }

    public void updateMeal(Meal meal) {
        mealDao.save(meal);
    }

    public List<Meal> getWinterMeals() {
        Double currentTemperatureInCentigrade = getCurrentTemperatureInCentigrade();

        if (currentTemperatureInCentigrade < MAX_WINTER_TEMP) return new ArrayList<>();

        return mealDao.findByIsWinterMeal(true);
    }

    private Double getCurrentTemperatureInCentigrade() {
        try {
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=38.1112268&longitude=13.3524434&hourly=temperature_2m&timezone=auto")
                    .asJson().getBody().getObject();

            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
