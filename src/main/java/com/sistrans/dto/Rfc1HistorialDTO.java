package com.sistrans.dto;

import java.time.LocalDateTime;

public class Rfc1HistorialDTO {
    private Long idServicio;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Double costoTotal;
    private String tipoServicio;
    private String puntoPartida;
    private String puntoDestino;
    private String nombreConductor;
    private String placaVehiculo;

    // Getters/Setters
    public Long getIdServicio() { return idServicio; }
    public void setIdServicio(Long idServicio) { this.idServicio = idServicio; }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }
    public Double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(Double costoTotal) { this.costoTotal = costoTotal; }
    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }
    public String getPuntoPartida() { return puntoPartida; }
    public void setPuntoPartida(String puntoPartida) { this.puntoPartida = puntoPartida; }
    public String getPuntoDestino() { return puntoDestino; }
    public void setPuntoDestino(String puntoDestino) { this.puntoDestino = puntoDestino; }
    public String getNombreConductor() { return nombreConductor; }
    public void setNombreConductor(String nombreConductor) { this.nombreConductor = nombreConductor; }
    public String getPlacaVehiculo() { return placaVehiculo; }
    public void setPlacaVehiculo(String placaVehiculo) { this.placaVehiculo = placaVehiculo; }
}
