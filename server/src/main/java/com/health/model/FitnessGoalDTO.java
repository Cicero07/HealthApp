package com.health.model;

import java.util.Date;

public class FitnessGoalDTO {

    private int goal_id;
    private int user_id;
    private String goal_type;
    private double target_value;
    private Date start_date;
    private Date end_date;
    private double progress;

    public FitnessGoalDTO(int goal_id, int user_id, String goal_type, double target_value, Date start_date, Date end_date, double progress) {
        this.goal_id = goal_id;
        this.user_id = user_id;
        this.goal_type = goal_type;
        this.target_value = target_value;
        this.start_date = start_date;
        this.end_date = end_date;
        this.progress = progress;
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

    public double getTarget_value() {
        return target_value;
    }

    public void setTarget_value(double target_value) {
        this.target_value = target_value;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
