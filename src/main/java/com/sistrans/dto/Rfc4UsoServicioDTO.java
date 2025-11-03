package com.sistrans.dto;

public class Rfc4UsoServicioDTO {
    private String tipoServicio;
    private Long numeroDeViajes;
    private Double porcentajeDelTotal;

    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }
    public Long getNumeroDeViajes() { return numeroDeViajes; }
    public void setNumeroDeViajes(Long numeroDeViajes) { this.numeroDeViajes = numeroDeViajes; }
    public Double getPorcentajeDelTotal() { return porcentajeDelTotal; }
    public void setPorcentajeDelTotal(Double porcentajeDelTotal) { this.porcentajeDelTotal = porcentajeDelTotal; }
}
