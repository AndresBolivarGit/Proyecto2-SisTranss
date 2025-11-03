package com.sistrans.entity;

import java.time.LocalDate;

public class TarjetaCredito {
    private Long usuarioCedula;
    private String numero;
    private String nombreTarjeta;
    private LocalDate fechaVencimiento;
    private String codigoSeguridad;

    public TarjetaCredito() {}

    public TarjetaCredito(Long usuarioCedula, String numero, String nombreTarjeta, 
                         LocalDate fechaVencimiento, String codigoSeguridad) {
        this.usuarioCedula = usuarioCedula;
        this.numero = numero;
        this.nombreTarjeta = nombreTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
    }

    public Long getUsuarioCedula() {
        return usuarioCedula;
    }

    public void setUsuarioCedula(Long usuarioCedula) {
        this.usuarioCedula = usuarioCedula;
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
