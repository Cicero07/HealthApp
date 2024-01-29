package com.health.controller;

import com.health.model.FitnessActivityDTO;
import com.health.model.FitnessGoalDTO;
import com.health.service.FitnessGoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class FitnessGoalController {

    FitnessGoalService fitnessGoalService;

    public FitnessGoalController(FitnessGoalService fitnessGoalService) {
        this.fitnessGoalService = fitnessGoalService;
    }

    @RequestMapping(path = "/createFitnessGoal", method = RequestMethod.POST)
    public ResponseEntity<String> createFitnessGoal(@RequestBody FitnessGoalDTO fitnessGoalDTO) {
        try {
            // Call the service layer to create the fitness goal
            fitnessGoalService.createFitnessGoalService(fitnessGoalDTO);
            return new ResponseEntity<>("Fitness goal created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create fitness goal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/updateGoalById", method = RequestMethod.PUT)
    public String updateWorkoutGoalsById(@RequestBody FitnessGoalDTO fitnessGoalDTO) {
        return fitnessGoalService.updateWorkoutGoalById(fitnessGoalDTO);
    }

    @RequestMapping(path = "/deleteWorkoutGoalById", method = RequestMethod.DELETE)
    public String deleteWorkoutGoalById(@RequestParam("goal_Id") int goal_id) {
        return fitnessGoalService.deleteWorkoutGoalByActivityId(goal_id);
    }

    @RequestMapping(path = "/getWorkoutGoalByUser" , method = RequestMethod.GET)
    public List<FitnessGoalDTO> getWorkoutGoalByUser(Principal principal){
        return fitnessGoalService.getWorkoutGoalByUser(principal.getName());
    }



}
