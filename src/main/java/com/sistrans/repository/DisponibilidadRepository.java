package com.sistrans.repository;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sistrans.entity.Disponibilidad;

@Repository
public class DisponibilidadRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public boolean verificarSuperposicion(Long cedulaConductor,
                                          LocalDate dia,
                                          String nuevaFranjaHoraria,
                                          Long idDisponibilidadExcluir) {

        final String sql =
            "SELECT COUNT(1) " +
            "  FROM DISPONIBILIDAD d " +
            " WHERE d.cedula_conductor = ? " +
            "   AND d.dia = ? " +
            "   AND ( ? IS NULL OR d.id_disponibilidad <> ? ) " +
            "   AND ( " +
            "         (SUBSTR(?, 1, 5) < SUBSTR(d.franja_horaria, 7, 5) " +
            "          AND SUBSTR(?, 7, 5) > SUBSTR(d.franja_horaria, 1, 5)) " +
            "       )";

        Integer count = jdbcTemplate.queryForObject(
            sql,
            Integer.class,
            cedulaConductor,
            dia,
            idDisponibilidadExcluir,
            idDisponibilidadExcluir,
            nuevaFranjaHoraria,
            nuevaFranjaHoraria
        );
        return count != null && count > 0;
    }

    public Long insertarDisponibilidad(Disponibilidad disponibilidad, Long cedulaConductor, String placaVehiculo) {
    final String insertSql =
        "INSERT INTO DISPONIBILIDAD (cedula_conductor, placa_vehiculo, dia, franja_horaria, tipo_transporte) " +
        "VALUES (?, ?, ?, ?, ?)";

    jdbcTemplate.update(
        insertSql,
        cedulaConductor,
        placaVehiculo,
        disponibilidad.getDia(),
        disponibilidad.getFranjaHoraria(),
        disponibilidad.getTipoTransporte()
    );

    final String getIdSql =
        "SELECT id_disponibilidad " +
        "FROM DISPONIBILIDAD " +
        "WHERE cedula_conductor = ? " +
        "AND placa_vehiculo = ? " +
        "AND dia = ? " +
        "AND franja_horaria = ? " +
        "AND tipo_transporte = ? " +
        "ORDER BY id_disponibilidad DESC FETCH FIRST 1 ROWS ONLY";

    return jdbcTemplate.queryForObject(
        getIdSql,
        Long.class,
        cedulaConductor,
        placaVehiculo,
        disponibilidad.getDia(),
        disponibilidad.getFranjaHoraria(),
        disponibilidad.getTipoTransporte()
    );
}


    public void actualizarDisponibilidad(Disponibilidad disponibilidad, Long cedulaConductor, String placaVehiculo) {
    final String sql =
        "UPDATE DISPONIBILIDAD " +
        "SET dia = ?, franja_horaria = ?, tipo_transporte = ?, placa_vehiculo = ? " +
        "WHERE id_disponibilidad = ?";

    jdbcTemplate.update(
        sql,
        disponibilidad.getDia(),
        disponibilidad.getFranjaHoraria(),
        disponibilidad.getTipoTransporte(),
        placaVehiculo,
        disponibilidad.getIdDisponibilidad()
    );
}
}
