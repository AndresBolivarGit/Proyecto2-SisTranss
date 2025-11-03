package com.sistrans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehiculoDTO {
    private String placa;
    private String tipo;
    private String marca;
    private Integer modelo;
    private String color;
    @JsonProperty("ciudad_placa")
    private String ciudadPlaca;
    @JsonProperty("capacidad_pasajero")
    private Integer capacidadPasajero;
    @JsonProperty("nivel_transporte")
    private String nivelTransporte;
    @JsonProperty("cedula_dueño")
    private Long cedulaDueño;

    public VehiculoDTO() {}

    public VehiculoDTO(String placa, String tipo, String marca, Integer modelo, String color,
                      String ciudadPlaca, Integer capacidadPasajero, String nivelTransporte, Long cedulaDueño) {
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.ciudadPlaca = ciudadPlaca;
        this.capacidadPasajero = capacidadPasajero;
        this.nivelTransporte = nivelTransporte;
        this.cedulaDueño = cedulaDueño;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCiudadPlaca() {
        return ciudadPlaca;
    }

    public void setCiudadPlaca(String ciudadPlaca) {
        this.ciudadPlaca = ciudadPlaca;
    }

    public Integer getCapacidadPasajero() {
        return capacidadPasajero;
    }

    public void setCapacidadPasajero(Integer capacidadPasajero) {
        this.capacidadPasajero = capacidadPasajero;
    }

    public String getNivelTransporte() {
        return nivelTransporte;
    }

    public void setNivelTransporte(String nivelTransporte) {
        this.nivelTransporte = nivelTransporte;
    }

    public Long getCedulaDueno() {
        return cedulaDueño;
    }

    public void setCedulaDueno(Long cedulaDueño) {
        this.cedulaDueño = cedulaDueño;
    }
}
