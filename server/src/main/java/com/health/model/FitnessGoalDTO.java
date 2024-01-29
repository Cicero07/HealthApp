package com.health.model;

import java.util.Date;

public class FitnessGoalDTO {

    private int goal_id;
    private int user_id;
    private String goal_type;
    private String start_date;
    private String end_date;
    private String action_plan;

    public FitnessGoalDTO(){}

    public FitnessGoalDTO(int goal_id,int user_id, String goal_type,String start_date, String end_date, String action_plan) {
        this.goal_id = goal_id;
        this.user_id = user_id;
        this.goal_type = goal_type;
        this.start_date = start_date;
        this.end_date = end_date;
        this.action_plan = action_plan;
    }

    public int getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getGoal_type() {
        return goal_type;
    }

    public void setGoal_type(String goal_type) {
        this.goal_type = goal_type;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getAction_plan() {
        return action_plan;
    }

    public void setAction_plan(String action_plan) {
        this.action_plan = action_plan;
    }
}
