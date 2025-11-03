package com.sistrans.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sistrans.entity.Resena;

@Repository
public class ResenaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertarResena(Resena resena) {
        String sql = "INSERT INTO RESEÑA (evaluacion_num, comentario, cedula_autor, cedula_evaluado, id_servicio) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, resena.getEvaluacionNum(), resena.getComentario(), 
                          resena.getCedulaAutor(), resena.getCedulaEvaluado(), resena.getIdServicio());
    }

    public boolean verificarSolicitanteServicio(Long cedulaAutor, Long idServicio) {
        String sql = "SELECT COUNT(*) FROM SERVICIO WHERE cedula_solicitante = ? AND id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, cedulaAutor, idServicio);
        return count != null && count > 0;
    }

    public boolean verificarConductorServicio(Long cedulaAutor, Long idServicio) {
        String sql = "SELECT COUNT(*) FROM SERVICIO WHERE cedula_conductor = ? AND id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, cedulaAutor, idServicio);
        return count != null && count > 0;
    }

    public String obtenerRolUsuario(Long cedulaUsuario) {
        String sql = "SELECT rol FROM USUARIO WHERE cedula = ?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, cedulaUsuario);
        } catch (Exception e) {
            return null;
        }
    }
}
