package com.sistrans.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sistrans.entity.Usuario;
import com.sistrans.entity.TarjetaCredito;

@Repository
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (cedula, nombre, correo, celular, rol) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, usuario.getCedula(), usuario.getNombre(), usuario.getCorreo(), 
                          usuario.getCelular(), usuario.getRol());
    }

    public void insertarTarjetaCredito(TarjetaCredito tarjeta) {
        String sql = "INSERT INTO TARJETA_CREDITO (usuario_cedula, numero, nombre_tarjeta, fecha_vencimiento, codigo_seguridad) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, tarjeta.getUsuarioCedula(), tarjeta.getNumero(), 
                          tarjeta.getNombreTarjeta(), tarjeta.getFechaVencimiento(), tarjeta.getCodigoSeguridad());
    }

    public boolean existeTarjetaPorUsuarioYNumero(Long cedula, String numeroTarjeta) {
        Integer n = jdbcTemplate.queryForObject(
            "SELECT COUNT(1) FROM TARJETA_CREDITO WHERE usuario_cedula = ? AND numero = ?",
            Integer.class, cedula, numeroTarjeta
        );
        return n != null && n > 0;
    }

}
