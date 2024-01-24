package com.health.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class FitnessActivityDTO {

    private int activity_id;
    private int user_id;
    private String activity_type;
    private Duration duration;
    private String intensity;

    //potentially add a notes section for specifically wht they did in their workout 
    private LocalDateTime current_Timestamp;

    public FitnessActivityDTO(int activity_id, int user_id, String activity_type, Duration duration, String intensity, LocalDateTime current_Timestamp) {
        this.activity_id = activity_id;
        this.user_id = user_id;
        this.activity_type = activity_type;
        this.duration = duration;
        this.intensity = intensity;
        this.current_Timestamp = current_Timestamp;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public LocalDateTime getCurrent_Timestamp() {
        return current_Timestamp;
    }

    public void setCurrent_Timestamp(LocalDateTime current_Timestamp) {
        this.current_Timestamp = current_Timestamp;
    }
}
