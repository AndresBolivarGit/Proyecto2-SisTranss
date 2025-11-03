package com.sistrans.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sistrans.entity.Servicio;
import com.sistrans.entity.ConductorDisponible;

@Repository
public class ServicioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ConductorDisponible buscarConductorDisponiblePorTipoYNivel(
            String tipoVehiculo,
            String nivelTransporte) {

        String sql = """
            SELECT d.cedula_conductor AS CEDULA, v.placa AS PLACA
              FROM DISPONIBILIDAD d
              JOIN VEHICULO v ON v.cedula_dueño = d.cedula_conductor
             WHERE d.estado = 'DISPONIBLE'
               AND v.tipo = ?
               AND v.nivel_transporte = ?
             FETCH FIRST 1 ROWS ONLY
        """;

        return jdbcTemplate.query(sql, new Object[]{tipoVehiculo, nivelTransporte}, rs -> {
            if (!rs.next()) return null;
            ConductorDisponible cd = new ConductorDisponible();
            cd.setCedula(rs.getLong("CEDULA"));
            cd.setPlaca(rs.getString("PLACA"));
            return cd;
        });
    }


    public void bloquearConductor(Long cedulaConductor) {
    String sql = """
        UPDATE DISPONIBILIDAD SET estado = 'ENSERVICIO' WHERE cedula_conductor = ?
           AND estado = 'DISPONIBLE'
        """;
    jdbcTemplate.update(sql, cedulaConductor);
}


    public void liberarConductorPorServicio(Long idServicio) {
    String sql = """
        UPDATE DISPONIBILIDAD d
           SET d.estado = 'DISPONIBLE'
         WHERE d.estado = 'ENSERVICIO'
           AND d.cedula_conductor = (
                 SELECT s.cedula_conductor
                   FROM SERVICIO s
                  WHERE s.id = ?
           )
        """;
    jdbcTemplate.update(sql, idServicio);
}

    public Long insertarServicio(Servicio s) {
        String sql = """
            INSERT INTO SERVICIO
              (fecha_hora_inicio, fecha_hora_fin, distancia, costo_total,
               tipo, cedula_solicitante, cedula_conductor, placa_vehiculo,
               id_punto_partida, tarjeta_credito)
            VALUES (CURRENT_TIMESTAMP, NULL, NULL, ?, ?, ?, ?, ?, ?, ?)
        """;

        jdbcTemplate.update(sql,
                s.getCostoTotal(),
                s.getTipo(),
                s.getCedulaSolicitante(),
                s.getCedulaConductor(),
                s.getPlacaVehiculo(),
                s.getIdPuntoPartida(),
                s.getTarjetaCredito()
        );

        return jdbcTemplate.queryForObject("SELECT MAX(id) FROM SERVICIO", Long.class);
    }

    public void actualizarHoraInicio(Long idServicio) {
        jdbcTemplate.update(
            "UPDATE SERVICIO SET fecha_hora_inicio = SYSTIMESTAMP WHERE id = ?",
            idServicio
        );
    }

    public void actualizarHoraFin(Long idServicio) {
        jdbcTemplate.update(
            "UPDATE SERVICIO SET fecha_hora_fin = SYSTIMESTAMP WHERE id = ?",
            idServicio
        );
    }

    public void finalizarServicio(Long idServicio, String distancia, Double costoTotal) {
        jdbcTemplate.update(
            "UPDATE SERVICIO SET distancia = ?, costo_total = ? WHERE id = ?",
            distancia, costoTotal, idServicio
        );
    }

    public boolean existeServicio(Long idServicio) {
        Integer count = jdbcTemplate.queryForObject(
            "SELECT COUNT(*) FROM SERVICIO WHERE id = ?",
            Integer.class,
            idServicio
        );
        return count != null && count > 0;
    }

    public void insertarDestino(Long idServicio, Long idPuntoDestino) {
        jdbcTemplate.update(
            "INSERT INTO DESTINOS_SERVICIO (id_servicio, id_punto_destino, orden) VALUES (?, ?, 1)",
            idServicio, idPuntoDestino
        );
    }

    public void insertarTransportePasajeros(Long idServicio, String nivel) {
        jdbcTemplate.update(
            "INSERT INTO TRANSPORTE_PASAJEROS (servicio_id, nivel) VALUES (?, ?)",
            idServicio, nivel
        );
    }

    public void insertarEntregaComida(Long idServicio, String restaurante) {
        jdbcTemplate.update(
            "INSERT INTO ENTREGA_COMIDA (servicio_id, nombre_restaurante) VALUES (?, ?)",
            idServicio, restaurante
        );
    }

    public void insertarTransporteMercancia(Long idServicio, Double carga) {
        jdbcTemplate.update(
            "INSERT INTO TRANSPORTE_MERCANCIA (servicio_id, carga) VALUES (?, ?)",
            idServicio, carga
        );
    }
}
