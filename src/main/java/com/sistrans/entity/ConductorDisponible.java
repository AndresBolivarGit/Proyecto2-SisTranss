package com.sistrans.entity;

public class ConductorDisponible {
    private Long cedula;
    private String placa;

    public ConductorDisponible() {}

    public ConductorDisponible(Long cedula, String placa) {
        this.cedula = cedula;
        this.placa = placa;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
