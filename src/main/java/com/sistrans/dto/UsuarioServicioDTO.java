package com.sistrans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioServicioDTO {
    private Long cedula;
    private String nombre;
    private String correo;
    private String celular;
    @JsonProperty("tarjeta_credito")
    private TarjetaCreditoDTO tarjetaCredito;

    public UsuarioServicioDTO() {}

    public UsuarioServicioDTO(Long cedula, String nombre, String correo, String celular, TarjetaCreditoDTO tarjetaCredito) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.tarjetaCredito = tarjetaCredito;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public TarjetaCreditoDTO getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCreditoDTO tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }
}
