package com.sistrans.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sistrans.entity.Vehiculo;

@Repository
public class VehiculoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertarVehiculo(Vehiculo vehiculo) {
        String sql = "INSERT INTO VEHICULO (placa, tipo, marca, modelo, color, ciudad_placa, capacidad_pasajero, nivel_transporte, cedula_dueño) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, vehiculo.getPlaca(), vehiculo.getTipo(), vehiculo.getMarca(), 
                          vehiculo.getModelo(), vehiculo.getColor(), vehiculo.getCiudadPlaca(), 
                          vehiculo.getCapacidadPasajero(), vehiculo.getNivelTransporte(), vehiculo.getCedulaDueno());
    }
}
