package com.health.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class FitnessActivityDTO {

    private int activity_id;
    private int user_id;
    private String activity_type;
    private String intensity;
    private String notes;
    private int duration_hours;
    private int duration_minutes;
    private String date;

    public FitnessActivityDTO(){} //Method preceding for mapRowToUser method

    public FitnessActivityDTO(int activity_id, int user_id, String activity_type, String intensity,String notes
            , int duration_hours,int duration_minutes, String date) {
        this.activity_id = activity_id;
        this.user_id = user_id;
        this.activity_type = activity_type;
        this.intensity = intensity;
        this.notes = notes;
        this.duration_hours = duration_hours;
        this.duration_minutes = duration_minutes;
        this.date = date;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getDuration_hours() {
        return duration_hours;
    }

    public void setDuration_hours(int duration_hours) {
        this.duration_hours = duration_hours;
    }

    public int getDuration_minutes() {
        return duration_minutes;
    }

    public void setDuration_minutes(int duration_minutes) {
        this.duration_minutes = duration_minutes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}



