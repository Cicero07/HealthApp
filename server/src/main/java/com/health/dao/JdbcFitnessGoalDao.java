package com.health.dao;

import com.health.model.FitnessGoalDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFitnessGoalDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcFitnessGoalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void createFitnessGoalDao(FitnessGoalDTO fitnessGoalDTO) {
        String sql = "INSERT INTO fitness_goal (user_id, goal_type, start_date, end_date, action_plan) " +
                "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                fitnessGoalDTO.getUser_id(),
                fitnessGoalDTO.getGoal_type(),
                fitnessGoalDTO.getStart_date(),
                fitnessGoalDTO.getEnd_date(),
                fitnessGoalDTO.getAction_plan());
    }

    public String updateWorkoutGoalByIdDao(FitnessGoalDTO fitnessGoalDTO){
        String sql = "UPDATE fitness_goal\n" +
                "SET goal_type = ?,\n" +
                "    start_date = ?,\n" +
                "    end_date = ?,\n" +
                "    action_plan = ?\n" +
                "WHERE goal_id = ?;\n";

        jdbcTemplate.update(sql,
                fitnessGoalDTO.getGoal_type(),
                fitnessGoalDTO.getStart_date(),
                fitnessGoalDTO.getEnd_date(),
                fitnessGoalDTO.getAction_plan(),
                fitnessGoalDTO.getGoal_id());

        return "Workout updated successfully for activity ID: " + fitnessGoalDTO.getGoal_id();
    }

    public String deleteWorkoutGoalByIdDao(int goal_id) {
        String sql = "DELETE FROM fitness_goal WHERE goal_id = ?";

        int rowsAffected = jdbcTemplate.update(sql, goal_id);

        if (rowsAffected > 0) {
            return "Workout with activity ID " + goal_id + " deleted successfully.";
        } else {
            return "No workout found with activity ID " + goal_id + ".";
        }
    }

    public List<FitnessGoalDTO> fetchWorkoutGoalsByUserDao(String username){
        List<FitnessGoalDTO> fitnessGoalDTOList = new ArrayList<>();

        String sql = "SELECT fitness_goal.goal_id,fitness_goal.user_id" +
                ",fitness_goal.goal_type, fitness_goal.start_date," +
                " fitness_goal.end_date, fitness_goal.action_plan\n" +
                "FROM fitness_goal\n" +
                "JOIN fitness_user ON fitness_goal.user_id = fitness_user.user_id\n" +
                "where fitness_user.username = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);

        while (results.next()){
            FitnessGoalDTO fitnessGoalDTO = mapRowToUser(results);
            fitnessGoalDTOList.add(fitnessGoalDTO);
        }

        return fitnessGoalDTOList;
    }


    private FitnessGoalDTO mapRowToUser (SqlRowSet rowSet){
        FitnessGoalDTO fitnessGoalDTO = new FitnessGoalDTO();
        fitnessGoalDTO.setGoal_id(rowSet.getInt("goal_id"));
        fitnessGoalDTO.setUser_id(rowSet.getInt("user_id"));
        fitnessGoalDTO.setGoal_type(rowSet.getString("goal_type"));
        fitnessGoalDTO.setStart_date(rowSet.getString("start_date"));
        fitnessGoalDTO.setEnd_date(rowSet.getString("end_date"));
        fitnessGoalDTO.setAction_plan(rowSet.getString("action_plan"));
        return fitnessGoalDTO;
    }
}


