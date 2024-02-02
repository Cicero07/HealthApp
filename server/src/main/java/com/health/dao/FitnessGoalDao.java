package com.health.dao;

import com.health.model.FitnessGoalDTO;

import java.util.List;

public interface FitnessGoalDao {

    public void createFitnessGoalDao(FitnessGoalDTO fitnessGoalDTO);

    public String updateWorkoutGoalByIdDao(FitnessGoalDTO fitnessGoalDTO);

    public String deleteWorkoutGoalByIdDao(int goal_id);

    public List<FitnessGoalDTO> fetchWorkoutGoalsByUserDao(String username);

}
