package com.health.dao;


import com.health.model.NutritionEntryDTO;
import com.health.model.NutritionTotalsDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcNutritionDao implements NutritionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcNutritionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createNutritionEntry(NutritionEntryDTO nutritionEntryDTO) {
        String sql = "INSERT INTO nutrition_entry (user_id, food_name, calories, proteins, carbs, fats, entry_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, nutritionEntryDTO.getUser_id(), nutritionEntryDTO.getFood_name(), nutritionEntryDTO.getCalories(),
                nutritionEntryDTO.getProteins(), nutritionEntryDTO.getCarbs(), nutritionEntryDTO.getFats(),
                nutritionEntryDTO.getEntry_date());
    }

    public List<NutritionEntryDTO> getNutritionEntriesForDate(String entryDate) {
        String sql = "SELECT * FROM nutrition_entry WHERE entry_date = ?";
        return jdbcTemplate.query(sql, new Object[]{entryDate}, new NutritionRowMapper());
    }

    public void updateNutritionTotalsForDate(String entryDate, NutritionTotalsDTO totals) {
        String sql = "UPDATE nutrition_totals SET total_calories = ?, total_proteins = ?, " +
                "total_carbs = ?, total_fats = ? WHERE entry_date = ?";
        jdbcTemplate.update(sql, totals.getTotalCalories(), totals.getTotalProteins(),
                totals.getTotalCarbs(), totals.getTotalFats(), entryDate);
    }

    public NutritionTotalsDTO getNutritionTotalsForDate(String entryDate) { // Need to alter to account for User ID
        String sql = "SELECT * FROM nutrition_totals WHERE entry_date = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{entryDate}, new NutritionTotalsRowMapper());
    }
}

