package com.health.dao;

import com.health.model.NutritionTotalsDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NutritionTotalsRowMapper implements RowMapper<NutritionTotalsDTO> {

    @Override
    public NutritionTotalsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        NutritionTotalsDTO nutritionTotals = new NutritionTotalsDTO();
        nutritionTotals.setUser_id(rs.getInt("user_id"));
        nutritionTotals.setTotalCalories(rs.getDouble("total_calories"));
        nutritionTotals.setTotalProteins(rs.getDouble("total_proteins"));
        nutritionTotals.setTotalCalories(rs.getDouble("total_carbs"));
        nutritionTotals.setTotalFats(rs.getDouble("total_fats"));
        return nutritionTotals;
    }
}

