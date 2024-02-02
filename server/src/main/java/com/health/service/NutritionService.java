package com.health.service;

import com.health.dao.JdbcNutritionDao;
import com.health.model.NutritionEntryDTO;
import com.health.model.NutritionTotalsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionService {

    private final JdbcNutritionDao jdbcNutritionDao;

    public NutritionService(JdbcNutritionDao jdbcNutritionDao) {
        this.jdbcNutritionDao = jdbcNutritionDao;
    }

    public void processNutritionEntry(NutritionEntryDTO nutritionEntryDTO) {
        jdbcNutritionDao.createNutritionEntry(nutritionEntryDTO);
        updateNutritionTotalsForDate(nutritionEntryDTO.getEntry_date());
    }

//    Above Method ^^
//    processNutritionEntry: This method is responsible for processing a new nutrition entry. It receives a NutritionEntryDTO object,
//    which represents the nutrition entry to be processed. Inside the method:
//    It calls the createNutritionEntry method of the JdbcNutritionDao to insert the nutrition entry into the database.
//    It then calls the updateNutritionTotalsForDate method to recalculate and update the nutrition totals for the entry date.


    private void updateNutritionTotalsForDate(String entryDate) {
        List<NutritionEntryDTO> entriesForDate = jdbcNutritionDao.getNutritionEntriesForDate(entryDate);
        NutritionTotalsDTO totals = calculateTotals(entriesForDate);
        jdbcNutritionDao.updateNutritionTotalsForDate(entryDate, totals);
    }

    // Above Method ^^
    // updateNutritionTotalsForDate: This method is responsible for updating the nutrition totals for a specific date. It receives the entry date as a parameter.
    // Inside the method: It retrieves all nutrition entries for the specified date using the getNutritionEntriesForDate method of the JdbcNutritionDao.
    // It calculates the nutrition totals based on the retrieved entries using the calculateTotals method.
    // Finally, it updates the nutrition totals in the database using the



    private NutritionTotalsDTO calculateTotals(List<NutritionEntryDTO> entries) {
        double totalCalories = 0;
        double totalProteins = 0;
        double totalCarbs = 0;
        double totalFats = 0;

        for (NutritionEntryDTO entry : entries) {
            totalCalories += entry.getCalories();
            totalProteins += entry.getProteins();
            totalCarbs += entry.getCarbs();
            totalFats += entry.getFats();
        }

        return new NutritionTotalsDTO(totalCalories, totalProteins, totalCarbs, totalFats);
    }

    public NutritionTotalsDTO getNutritionTotalsForDate(String entryDate) {
        return jdbcNutritionDao.getNutritionTotalsForDate(entryDate);
    }
}
