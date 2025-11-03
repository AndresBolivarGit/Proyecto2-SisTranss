package com.sistrans.entity;

public class Vehiculo {
    private String placa;
    private String tipo;
    private String marca;
    private Integer modelo;
    private String color;
    private String ciudadPlaca;
    private Integer capacidadPasajero;
    private String nivelTransporte;
    private Long cedulaDueno;

    public Vehiculo() {}

    public Vehiculo(String placa, String tipo, String marca, Integer modelo, String color,
                   String ciudadPlaca, Integer capacidadPasajero, String nivelTransporte, Long cedulaDueno) {
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.ciudadPlaca = ciudadPlaca;
        this.capacidadPasajero = capacidadPasajero;
        this.nivelTransporte = nivelTransporte;
        this.cedulaDueno = cedulaDueno;
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
        return cedulaDueno;
    }

    public void setCedulaDueno(Long cedulaDueno) {
        this.cedulaDueno = cedulaDueno;
    }
}
