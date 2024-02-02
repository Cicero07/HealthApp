package com.health.dao;

import com.health.model.NutritionEntryDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NutritionRowMapper implements RowMapper<NutritionEntryDTO> {

    @Override
    public NutritionEntryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        NutritionEntryDTO nutritionEntry = new NutritionEntryDTO();
        nutritionEntry.setNutrition_id(rs.getInt("nutrition_id"));
        nutritionEntry.setUser_id(rs.getInt("user_id"));
        nutritionEntry.setFood_name(rs.getString("food_name"));
        nutritionEntry.setCalories(rs.getDouble("calories"));
        nutritionEntry.setProteins(rs.getDouble("proteins"));
        nutritionEntry.setCarbs(rs.getDouble("carbs"));
        nutritionEntry.setFats(rs.getDouble("fats"));
        nutritionEntry.setEntry_date(rs.getString("entry_date"));
        return nutritionEntry;
    }
}

