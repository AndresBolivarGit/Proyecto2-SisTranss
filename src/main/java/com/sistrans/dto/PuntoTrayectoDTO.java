package com.sistrans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PuntoTrayectoDTO {
    @JsonProperty("id_punto")
    private Long idPunto;
    private String direccion;
    private String ciudad;
    private String coordenadas;
    @JsonProperty("tipo_punto")
    private String tipoPunto;

    public PuntoTrayectoDTO() {}

    public PuntoTrayectoDTO(Long idPunto, String direccion, String ciudad, String coordenadas, String tipoPunto) {
        this.idPunto = idPunto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.coordenadas = coordenadas;
        this.tipoPunto = tipoPunto;
    }

    public Long getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(Long idPunto) {
        this.idPunto = idPunto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getTipoPunto() {
        return tipoPunto;
    }

    public void setTipoPunto(String tipoPunto) {
        this.tipoPunto = tipoPunto;
    }
}
