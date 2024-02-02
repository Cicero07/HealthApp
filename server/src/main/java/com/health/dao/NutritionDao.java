package com.health.dao;

import com.health.model.NutritionEntryDTO;
import com.health.model.NutritionTotalsDTO;

import java.util.List;

public interface NutritionDao {

    public void createNutritionEntry(NutritionEntryDTO nutritionEntryDTO);

    public List<NutritionEntryDTO> getNutritionEntriesForDate(String entryDate);

    public void updateNutritionTotalsForDate(String entryDate, NutritionTotalsDTO totals);

    public NutritionTotalsDTO getNutritionTotalsForDate(String entryDate);
}
