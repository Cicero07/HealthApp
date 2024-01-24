package com.health.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcFitnessActivityDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcFitnessActivityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
