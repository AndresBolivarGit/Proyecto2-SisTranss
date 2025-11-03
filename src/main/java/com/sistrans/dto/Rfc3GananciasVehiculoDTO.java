package com.sistrans.dto;

public class Rfc3GananciasVehiculoDTO {
    private String placaVehiculo;
    private String tipoServicio;
    private Double gananciaTotal;

    public String getPlacaVehiculo() { return placaVehiculo; }
    public void setPlacaVehiculo(String placaVehiculo) { this.placaVehiculo = placaVehiculo; }
    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }
    public Double getGananciaTotal() { return gananciaTotal; }
    public void setGananciaTotal(Double gananciaTotal) { this.gananciaTotal = gananciaTotal; }
}
