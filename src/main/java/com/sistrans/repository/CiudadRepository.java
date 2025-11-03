package com.sistrans.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CiudadRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertarCiudad(String nombre) {
        String sql = "INSERT INTO CIUDAD (nombre) VALUES (?)";
        jdbcTemplate.update(sql, nombre);
    }
}
