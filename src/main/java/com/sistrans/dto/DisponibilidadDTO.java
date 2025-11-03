package com.sistrans.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisponibilidadDTO {
    @JsonProperty("id_disponibilidad")
    private Long idDisponibilidad;
    private LocalDate dia;
    @JsonProperty("franja_horaria")
    private String franjaHoraria;
    @JsonProperty("tipo_transporte")
    private String tipoTransporte;
    @JsonProperty("cedula_conductor")
    private Long cedulaConductor;
    @JsonProperty("placa_vehiculo")
    private String placaVehiculo;

    public DisponibilidadDTO() {}

    public DisponibilidadDTO(Long idDisponibilidad, LocalDate dia, String franjaHoraria, String tipoTransporte) {
        this.idDisponibilidad = idDisponibilidad;
        this.dia = dia;
        this.franjaHoraria = franjaHoraria;
        this.tipoTransporte = tipoTransporte;
    }

    public Long getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(Long idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public String getFranjaHoraria() {
        return franjaHoraria;
    }

    public void setFranjaHoraria(String franjaHoraria) {
        this.franjaHoraria = franjaHoraria;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public Long getCedulaConductor() {
        return cedulaConductor;
    }

    public void setCedulaConductor(Long cedulaConductor) {
        this.cedulaConductor = cedulaConductor;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }
}
