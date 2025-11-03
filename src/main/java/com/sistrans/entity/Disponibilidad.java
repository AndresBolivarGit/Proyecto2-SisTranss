package com.sistrans.entity;

import java.time.LocalDate;

public class Disponibilidad {
    private Long idDisponibilidad;
    private LocalDate dia;
    private String franjaHoraria;
    private String tipoTransporte;

    public Disponibilidad() {}

    public Disponibilidad(Long idDisponibilidad, LocalDate dia, String franjaHoraria, String tipoTransporte) {
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
}
