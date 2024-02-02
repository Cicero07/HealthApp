package com.health.model;

public class NutritionTotalsDTO {

    private int user_id;
    private double totalCalories;
    private double totalProteins;
    private double totalCarbs;
    private double totalFats;

    public NutritionTotalsDTO(){}

    public NutritionTotalsDTO(int user_id,double totalCalories, double totalProteins, double totalCarbs, double totalFats) {
        this.user_id = user_id;
        this.totalCalories = totalCalories;
        this.totalProteins = totalProteins;
        this.totalCarbs = totalCarbs;
        this.totalFats = totalFats;
    }
    public NutritionTotalsDTO(double totalCalories, double totalProteins, double totalCarbs, double totalFats) {
        this.totalCalories = totalCalories;
        this.totalProteins = totalProteins;
        this.totalCarbs = totalCarbs;
        this.totalFats = totalFats;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getTotalProteins() {
        return totalProteins;
    }

    public void setTotalProteins(double totalProteins) {
        this.totalProteins = totalProteins;
    }

    public double getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(double totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public double getTotalFats() {
        return totalFats;
    }

    public void setTotalFats(double totalFats) {
        this.totalFats = totalFats;
    }
}
