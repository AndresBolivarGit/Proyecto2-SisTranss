package com.sistrans.repository;

import com.sistrans.dto.Rfc1HistorialDTO;
import com.sistrans.dto.Rfc2TopConductorDTO;
import com.sistrans.dto.Rfc3GananciasVehiculoDTO;
import com.sistrans.dto.Rfc4UsoServicioDTO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RfcRepository {

    private final JdbcTemplate jdbc;

    public RfcRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static final String SQL_RFC1 = """
SELECT
    s.id                AS id_servicio,
    s.fecha_hora_inicio AS fecha_inicio,
    s.fecha_hora_fin    AS fecha_fin,
    s.costo_total       AS costo_total,
    s.tipo              AS tipo_servicio,
    pp.direccion        AS punto_partida,
    pd.direccion        AS punto_destino,
    uc.nombre           AS nombre_conductor,
    v.placa             AS placa_vehiculo
    FROM SERVICIO s
    LEFT JOIN PUNTO_TRAYECTO pp ON pp.id_punto = s.id_punto_partida
    LEFT JOIN DESTINOS_SERVICIO ds ON ds.id_servicio = s.id
    LEFT JOIN PUNTO_TRAYECTO pd ON pd.id_punto = ds.id_punto_destino AND ds.orden = 1
    LEFT JOIN USUARIO uc ON uc.cedula = s.cedula_conductor
    LEFT JOIN VEHICULO v ON v.placa = s.placa_vehiculo
    WHERE s.cedula_solicitante = ?
    ORDER BY s.id DESC
    FETCH FIRST ? ROWS ONLY
    """;

    public List<Rfc1HistorialDTO> rfc1Historial(Long cedula, int limite) {
    return jdbc.query(SQL_RFC1, (rs, rowNum) -> {
        Rfc1HistorialDTO dto = new Rfc1HistorialDTO();
        dto.setIdServicio(rs.getLong("id_servicio"));
        
        java.sql.Timestamp ti = rs.getTimestamp("fecha_inicio");
        dto.setFechaInicio(ti != null ? ti.toLocalDateTime() : null);

        java.sql.Timestamp tf = rs.getTimestamp("fecha_fin");
        dto.setFechaFin(tf != null ? tf.toLocalDateTime() : null);

        dto.setCostoTotal(rs.getDouble("costo_total"));
        dto.setTipoServicio(rs.getString("tipo_servicio"));
        dto.setPuntoPartida(rs.getString("punto_partida"));
        dto.setPuntoDestino(rs.getString("punto_destino"));
        dto.setNombreConductor(rs.getString("nombre_conductor"));
        dto.setPlacaVehiculo(rs.getString("placa_vehiculo"));

        return dto;
    }, cedula, limite <= 0 ? 50 : limite);
}
    
    public List<Rfc2TopConductorDTO> rfc2TopConductores(Integer limite) {
    String base = """
        SELECT
            u.cedula        AS cedula,
            u.nombre        AS nombre,
            u.correo        AS correo,
            COUNT(s.id)     AS total_servicios_prestados
        FROM USUARIO u
        INNER JOIN SERVICIO s
            ON u.cedula = s.cedula_conductor
        WHERE u.rol = 'CONDUCTOR'
        GROUP BY u.cedula, u.nombre, u.correo
        ORDER BY total_servicios_prestados DESC
    """;

    String sql = (limite == null || limite <= 0)
            ? base
            : "SELECT * FROM (" + base + ") WHERE ROWNUM <= " + limite;

    return jdbc.query(sql, (rs, rowNum) -> {
        Rfc2TopConductorDTO d = new Rfc2TopConductorDTO();
        d.setCedula(rs.getString("cedula"));
        d.setNombre(rs.getString("nombre"));
        d.setCorreo(rs.getString("correo"));
        d.setTotalServiciosPrestados(rs.getLong("total_servicios_prestados"));
        return d;
    });
        }

    public List<Rfc3GananciasVehiculoDTO> rfc3GananciasPorConductor(String cedulaConductor) {
    String sql = """
        SELECT
            s.placa_vehiculo                AS placa_vehiculo,
            s.tipo                          AS tipo_servicio,
            SUM(s.costo_total * 0.60)       AS ganancia_total
        FROM SERVICIO s
        WHERE s.cedula_conductor = ?
        GROUP BY s.placa_vehiculo, s.tipo
        ORDER BY s.placa_vehiculo, ganancia_total DESC
    """;

    return jdbc.query(sql, (rs, rowNum) -> {
        Rfc3GananciasVehiculoDTO d = new Rfc3GananciasVehiculoDTO();
        d.setPlacaVehiculo(rs.getString("placa_vehiculo"));
        d.setTipoServicio(rs.getString("tipo_servicio"));
        d.setGananciaTotal(rs.getDouble("ganancia_total"));
        return d;
    }, cedulaConductor);
}

    public List<Rfc4UsoServicioDTO> rfc4UsoServicios(LocalDateTime desde, LocalDateTime hasta) {

    String sqlSinFechas = """
        WITH tot AS ( SELECT COUNT(*) AS total FROM SERVICIO )
        SELECT
          s.tipo AS tipo_servicio,
          COUNT(*) AS numero_viajes,
          ROUND( (COUNT(*) * 100.0) / NULLIF((SELECT total FROM tot), 0), 2) AS porcentaje_total
        FROM SERVICIO s
        GROUP BY s.tipo
        ORDER BY numero_viajes DESC
    """;

    String sqlConFechas = """
        WITH tot AS (
          SELECT COUNT(*) AS total
          FROM SERVICIO s
          WHERE s.fecha_hora_inicio BETWEEN ? AND ?
        )
        SELECT
          s.tipo AS tipo_servicio,
          COUNT(*) AS numero_viajes,
          ROUND( (COUNT(*) * 100.0) / NULLIF((SELECT total FROM tot), 0), 2) AS porcentaje_total
        FROM SERVICIO s
        WHERE s.fecha_hora_inicio BETWEEN ? AND ?
        GROUP BY s.tipo
        ORDER BY numero_viajes DESC
    """;

    RowMapper<Rfc4UsoServicioDTO> mapper = (rs, i) -> {
    Rfc4UsoServicioDTO dto = new Rfc4UsoServicioDTO();
    dto.setTipoServicio(rs.getString("tipo_servicio"));
    dto.setNumeroDeViajes(rs.getLong("numero_viajes"));
    dto.setPorcentajeDelTotal(rs.getDouble("porcentaje_total"));
    return dto;
    };

    if (desde == null || hasta == null) {
        return jdbc.query(sqlSinFechas, mapper);
    }

    Timestamp d = Timestamp.valueOf(desde);
    Timestamp h = Timestamp.valueOf(hasta);

    return jdbc.query(sqlConFechas, mapper, d, h, d, h);
    }
}
