package com.sistrans.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TarjetaCreditoDTO {
    private String numero;
    @JsonProperty("nombre_tarjeta")
    private String nombreTarjeta;
    @JsonProperty("fecha_vencimiento")
    private LocalDate fechaVencimiento;
    @JsonProperty("codigo_seguridad")
    private String codigoSeguridad;

    public TarjetaCreditoDTO() {}

    public TarjetaCreditoDTO(String numero, String nombreTarjeta, LocalDate fechaVencimiento, String codigoSeguridad) {
        this.numero = numero;
        this.nombreTarjeta = nombreTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
}
