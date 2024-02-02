package com.health.service;

import com.health.dao.JdbcFitnessGoalDao;
import com.health.model.FitnessActivityDTO;
import com.health.model.FitnessGoalDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessGoalService {

   private final JdbcFitnessGoalDao jdbcFitnessGoalDao;

    public FitnessGoalService(JdbcFitnessGoalDao jdbcFitnessGoalDao) {
        this.jdbcFitnessGoalDao = jdbcFitnessGoalDao;
    }

    public void createFitnessGoalService(FitnessGoalDTO fitnessGoalDTO) {
        jdbcFitnessGoalDao.createFitnessGoalDao(fitnessGoalDTO);
    }

    public String updateWorkoutGoalById(FitnessGoalDTO fitnessGoalDTO) {
        return jdbcFitnessGoalDao.updateWorkoutGoalByIdDao(fitnessGoalDTO);
    }

    public String deleteWorkoutGoalByActivityId(int goal_id) {
        // Validate token here if needed

        return jdbcFitnessGoalDao.deleteWorkoutGoalByIdDao(goal_id);
    }

    public List<FitnessGoalDTO> getWorkoutGoalByUser(String username){
        return jdbcFitnessGoalDao.fetchWorkoutGoalsByUserDao(username);
    }
}
