package com.health.model;

import java.util.Date;

public class NutritionEntryDTO {

    private int nutrition_id;
    private int user_id;
    private String food_name;
    private double calories;
    private double proteins;
    private double carbs;
    private double fats;
    private Date entry_date;

    public int getNutrition_id() {
        return nutrition_id;
    }

    public void setNutrition_id(int nutrition_id) {
        this.nutrition_id = nutrition_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public NutritionEntryDTO(int nutrition_id, int user_id, String food_name, double calories, double proteins, double carbs, double fats, Date entry_date) {
        this.nutrition_id = nutrition_id;
        this.user_id = user_id;
        this.food_name = food_name;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.entry_date = entry_date;


    }
}
