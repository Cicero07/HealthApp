package com.health.dao;

import com.health.model.FitnessActivityDTO;

import java.util.List;

public interface FitnessActivityDao {

    public void logFitnessActivity(FitnessActivityDTO fitnessActivityDTO);

    public List<FitnessActivityDTO> fetchWorkoutsByType(String username, String activityType);

    public List<FitnessActivityDTO> fetchWorkoutListByUser(String username);

    public List<FitnessActivityDTO> fetchWorkoutByDate(String username, String date);

    public String updateWorkoutsByActivityId(FitnessActivityDTO fitnessActivityDTO);

    public String deleteWorkoutByActivityId(int activityId);
}
