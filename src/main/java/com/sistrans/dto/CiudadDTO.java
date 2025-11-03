package com.sistrans.dto;

public class CiudadDTO {
    private String nombre;

    public CiudadDTO() {}

    public CiudadDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
