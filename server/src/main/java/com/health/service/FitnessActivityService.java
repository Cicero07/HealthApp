package com.health.service;

import com.health.dao.JdbcFitnessActivityDao;
import com.health.model.FitnessActivityDTO;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class FitnessActivityService {

    private final JdbcFitnessActivityDao jdbcFitnessActivityDao;

    public FitnessActivityService(JdbcFitnessActivityDao jdbcFitnessActivityDao) {
        this.jdbcFitnessActivityDao = jdbcFitnessActivityDao;
    }

    public void logFitnessService(FitnessActivityDTO fitnessActivity) {
        // Return Type -> JSON success or error(String) to propagate to UI
        jdbcFitnessActivityDao.logFitnessActivity(fitnessActivity);
    }

    public List<FitnessActivityDTO> getWorkoutByTypeService(String username, String activityType){
      return jdbcFitnessActivityDao.fetchWorkoutsByType(username, activityType);
    }

    public List<FitnessActivityDTO> getWorkoutByUserService(String username){
        return jdbcFitnessActivityDao.fetchWorkoutListByUser(username);
    }

    public List<FitnessActivityDTO> getWorkoutByDateService(String username, String date){
        return jdbcFitnessActivityDao.fetchWorkoutByDate(username, date);
    }

    public String updateWorkoutsByUsername(FitnessActivityDTO fitnessActivityDTO) {
        return jdbcFitnessActivityDao.updateWorkoutsByActivityId(fitnessActivityDTO);
    }

    public String deleteWorkoutByActivityId(int activityId) {
        // Validate token here if needed

        return jdbcFitnessActivityDao.deleteWorkoutByActivityId(activityId);
    }

}
