package com.sistrans.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sistrans.entity.PuntoTrayecto;

@Repository
public class PuntoTrayectoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long insertarPunto(PuntoTrayecto punto) {
        String sql = "INSERT INTO PUNTO_TRAYECTO (direccion, ciudad, coordenadas, tipo_punto) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, punto.getDireccion(), punto.getCiudad(), punto.getCoordenadas(), punto.getTipoPunto());
        
        String getIdSql = "SELECT id_punto FROM PUNTO_TRAYECTO WHERE direccion = ? AND ciudad = ? ORDER BY id_punto DESC FETCH FIRST 1 ROWS ONLY";
        return jdbcTemplate.queryForObject(getIdSql, Long.class, punto.getDireccion(), punto.getCiudad());
    }
}
