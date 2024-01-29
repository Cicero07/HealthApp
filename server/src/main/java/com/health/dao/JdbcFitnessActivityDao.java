package com.health.dao;

import com.health.exceptionhandling.DaoException;
import com.health.model.FitnessActivityDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFitnessActivityDao implements FitnessActivityDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcFitnessActivityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void logFitnessActivity(FitnessActivityDTO fitnessActivityDTO) {
        // Return Type -> JSON success or error(String) to propagate to UI

        String sql = "INSERT INTO fitness_activity (user_id,activity_type, intensity, " +
                "notes, duration_hours, duration_minutes, date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(sql, fitnessActivityDTO.getUser_id(),
                    fitnessActivityDTO.getActivity_type(),fitnessActivityDTO.getIntensity(),
                    fitnessActivityDTO.getNotes(),fitnessActivityDTO.getDuration_hours(),
                    fitnessActivityDTO.getDuration_minutes(), fitnessActivityDTO.getDate());


        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataAccessException e) {
            throw new DaoException("Data access exception", e);
        }
    }

    public List<FitnessActivityDTO> fetchWorkoutsByType(String username, String activityType){
        List<FitnessActivityDTO> fitnessActivityDTOList = new ArrayList<>();

        String sql = "SELECT fitness_activity.activity_type, fitness_activity.intensity," +
                " fitness_activity.notes,fitness_activity.duration_hours," +
                "fitness_activity.duration_minutes,fitness_activity.date\n" +
                "from fitness_activity\n" +
                "JOIN fitness_user on fitness_activity.user_id = fitness_user.user_id\n" +
                "where fitness_user.username = ? AND fitness_activity.activity_type = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username, activityType);

        while (results.next()){
            FitnessActivityDTO fitnessActivityDTO = mapRowToUser(results);
            fitnessActivityDTOList.add(fitnessActivityDTO);
        }
        return fitnessActivityDTOList;
    }

    public List<FitnessActivityDTO> fetchWorkoutListByUser(String username){
        List<FitnessActivityDTO> fitnessActivityDTOList = new ArrayList<>();

        String sql = "SELECT fitness_activity.activity_type, fitness_activity.intensity," +
                " fitness_activity.notes,fitness_activity.duration_hours," +
                "fitness_activity.duration_minutes,fitness_activity.date\n" +
                "from fitness_activity\n" +
                "JOIN fitness_user on fitness_activity.user_id = fitness_user.user_id\n" +
                "where fitness_user.username = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);

        while (results.next()){
            FitnessActivityDTO fitnessActivityDTO = mapRowToUser(results);
            fitnessActivityDTOList.add(fitnessActivityDTO);
        }

        return fitnessActivityDTOList;
    }

    public List<FitnessActivityDTO> fetchWorkoutByDate(String username, String date){
        List<FitnessActivityDTO> fitnessActivityDTOList = new ArrayList<>();

        String sql = "SELECT fitness_activity.activity_type, fitness_activity.intensity,fitness_activity.notes, \n" +
                "fitness_activity.duration_hours,fitness_activity.duration_minutes,fitness_activity.date\n" +
                "FROM fitness_activity\n" +
                "JOIN fitness_user on fitness_activity.user_id = fitness_user.user_id\n" +
                "WHERE fitness_user.username = ? AND fitness_activity.date = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username, date);

        while (results.next()){
            FitnessActivityDTO fitnessActivityDTO = mapRowToUser(results);
            fitnessActivityDTOList.add(fitnessActivityDTO);
        }

        return fitnessActivityDTOList;
    }


    public String updateWorkoutsByActivityId(FitnessActivityDTO fitnessActivityDTO) {
        String sql = "UPDATE fitness_activity SET activity_type = ?, intensity = ?, notes = ?, duration_hours = ?, " +
                "duration_minutes = ?, date = ? WHERE activity_id = ?";

        jdbcTemplate.update(sql, fitnessActivityDTO.getActivity_type(), fitnessActivityDTO.getIntensity(),
                fitnessActivityDTO.getNotes(), fitnessActivityDTO.getDuration_hours(),
                fitnessActivityDTO.getDuration_minutes(), fitnessActivityDTO.getDate(),
                fitnessActivityDTO.getActivity_id());

        return "Workout updated successfully for activity ID: " + fitnessActivityDTO.getActivity_id();
    }

    public String deleteWorkoutByActivityId(int activityId) {
        String sql = "DELETE FROM fitness_activity WHERE activity_id = ?";

        int rowsAffected = jdbcTemplate.update(sql, activityId);

        if (rowsAffected > 0) {
            return "Workout with activity ID " + activityId + " deleted successfully.";
        } else {
            return "No workout found with activity ID " + activityId + ".";
        }
    }











    // Have DAO Methods go above Mapping method
    private FitnessActivityDTO mapRowToUser(SqlRowSet rowSet){
        FitnessActivityDTO fitnessActivityDTO = new FitnessActivityDTO();
        fitnessActivityDTO.setActivity_type(rowSet.getString("activity_type"));
        fitnessActivityDTO.setIntensity(rowSet.getString("intensity"));
        fitnessActivityDTO.setNotes(rowSet.getString("notes"));
        fitnessActivityDTO.setDuration_hours(rowSet.getInt("duration_hours"));
        fitnessActivityDTO.setDuration_minutes(rowSet.getInt("duration_minutes"));
        fitnessActivityDTO.setDate(rowSet.getString("date"));
        return fitnessActivityDTO;
    }
}
