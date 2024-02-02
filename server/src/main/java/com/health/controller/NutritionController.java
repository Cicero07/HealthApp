package com.health.controller;


import com.health.model.NutritionEntryDTO;
import com.health.model.NutritionTotalsDTO;
import com.health.service.NutritionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("isAuthenticated()")
public class NutritionController {

    private final NutritionService nutritionService;

    public NutritionController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }

    // Endpoint to create a new nutrition entry
    @PostMapping("/nutrition/entries")
    public ResponseEntity<String> createNutritionEntry(@RequestBody NutritionEntryDTO nutritionEntryDTO) {
        try {
            nutritionService.processNutritionEntry(nutritionEntryDTO);
            return ResponseEntity.ok("Nutrition entry created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create nutrition entry: " + e.getMessage());
        }
    }

    // Endpoint to get nutrition totals for a specific date
    @GetMapping("/nutrition/totals")
    public ResponseEntity<NutritionTotalsDTO> getNutritionTotals(@RequestParam("date") String date) {
        try {
            NutritionTotalsDTO nutritionTotals = nutritionService.getNutritionTotalsForDate(date);
            return ResponseEntity.ok(nutritionTotals);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new NutritionTotalsDTO()); // You can return a default DTO or handle the error as needed
        }
    }
}

