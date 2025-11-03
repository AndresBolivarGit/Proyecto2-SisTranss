package com.sistrans.entity;

import java.time.LocalDateTime;

public class Servicio {
    private Long id;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private String distancia;
    private Double costoTotal;
    private String tipo;
    private Long cedulaSolicitante;
    private Long cedulaConductor;
    private String placaVehiculo;
    private Long idPuntoPartida;
    private String tarjetaCredito;

    public Servicio() {}

    public Servicio(Long id, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin,
                   String distancia, Double costoTotal, String tipo, Long cedulaSolicitante,
                   Long cedulaConductor, String placaVehiculo, Long idPuntoPartida, String tarjetaCredito) {
        this.id = id;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.distancia = distancia;
        this.costoTotal = costoTotal;
        this.tipo = tipo;
        this.cedulaSolicitante = cedulaSolicitante;
        this.cedulaConductor = cedulaConductor;
        this.placaVehiculo = placaVehiculo;
        this.idPuntoPartida = idPuntoPartida;
        this.tarjetaCredito = tarjetaCredito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getCedulaSolicitante() {
        return cedulaSolicitante;
    }

    public void setCedulaSolicitante(Long cedulaSolicitante) {
        this.cedulaSolicitante = cedulaSolicitante;
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

    public Long getIdPuntoPartida() {
        return idPuntoPartida;
    }

    public void setIdPuntoPartida(Long idPuntoPartida) {
        this.idPuntoPartida = idPuntoPartida;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }
}
