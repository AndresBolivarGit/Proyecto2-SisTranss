package com.sistrans.dto;

public class Rfc2TopConductorDTO {
    private String cedula;
    private String nombre;
    private String correo;
    private Long totalServiciosPrestados;

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public Long getTotalServiciosPrestados() { return totalServiciosPrestados; }
    public void setTotalServiciosPrestados(Long totalServiciosPrestados) { this.totalServiciosPrestados = totalServiciosPrestados; }
}
