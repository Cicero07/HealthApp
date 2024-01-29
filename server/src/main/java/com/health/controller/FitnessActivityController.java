package com.health.controller;

import com.health.exceptionhandling.IntegrationException;
import com.health.model.FitnessActivityDTO;
import com.health.service.FitnessActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class FitnessActivityController {

    private FitnessActivityService fitnessActivityService;

    public FitnessActivityController(FitnessActivityService fitnessActivityService) {
        this.fitnessActivityService = fitnessActivityService;
    }

    @RequestMapping(path = "/addWorkout", method = RequestMethod.POST)
    public void logFitnessActivity(@RequestBody FitnessActivityDTO fitnessActivity) {
        // Return Type -> JSON success or error(String) to propagate to UI
        fitnessActivityService.logFitnessService(fitnessActivity);
    }


  @RequestMapping(path = "/getWorkoutByType", method = RequestMethod.GET)
    public List<FitnessActivityDTO> getWorkoutByType(Principal principal, @RequestParam(name = "activityType") String activityType){
     return fitnessActivityService.getWorkoutByTypeService(principal.getName(), activityType);
    }

    @RequestMapping(path = "/getWorkoutByUser", method = RequestMethod.GET)
    public List<FitnessActivityDTO> getWorkoutByUser(Principal principal){
        return fitnessActivityService.getWorkoutByUserService(principal.getName());
    }

    @RequestMapping(path = "/getWorkoutByDate", method = RequestMethod.GET)
    public List<FitnessActivityDTO> getWorkoutByDate(Principal principal, @RequestParam(name = "date") String date){
        return fitnessActivityService.getWorkoutByDateService(principal.getName(), date);
    }

    @RequestMapping(path = "/updateWorkoutById", method = RequestMethod.PUT)
    public String updateWorkoutsByUsername(@RequestBody FitnessActivityDTO fitnessActivityDTO) {
        return fitnessActivityService.updateWorkoutsByUsername(fitnessActivityDTO);
    }


    @RequestMapping(path = "/deleteWorkoutById", method = RequestMethod.DELETE)
    public String deleteWorkoutByActivityId(@RequestParam("activityId") int activityId) {
        return fitnessActivityService.deleteWorkoutByActivityId(activityId);
    }






}
