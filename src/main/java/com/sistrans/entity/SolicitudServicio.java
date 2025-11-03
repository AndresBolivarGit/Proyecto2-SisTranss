package com.sistrans.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudServicio {
    @JsonProperty("cedula_solicitante")
    private Long cedulaSolicitante;
    @JsonProperty("id_punto_partida")
    private Long idPuntoPartida;
    @JsonProperty("ids_puntos_destino")
    private List<Long> idsPuntosDestino;
    @JsonProperty("tipo_servicio")
    private String tipoServicio;
    @JsonProperty("numero_tarjeta")
    private String numeroTarjeta;
    
    @JsonProperty("nivel_transporte")
    private String nivelTransporte; 
    @JsonProperty("nombre_restaurante")
    private String nombreRestaurante;
    @JsonProperty("peso_carga")
    private Double pesoCarga; 

    public Long getCedulaSolicitante() {
        return cedulaSolicitante;
    }
    public void setCedulaSolicitante(Long cedulaSolicitante) {
        this.cedulaSolicitante = cedulaSolicitante;
    }
    public Long getIdPuntoPartida() {
        return idPuntoPartida;
    }
    public void setIdPuntoPartida(Long idPuntoPartida) {
        this.idPuntoPartida = idPuntoPartida;
    }
    public List<Long> getIdsPuntosDestino() {
        return idsPuntosDestino;
    }
    public void setIdsPuntosDestino(List<Long> idsPuntosDestino) {
        this.idsPuntosDestino = idsPuntosDestino;
    }
    public String getTipoServicio() {
        return tipoServicio;
    }
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public String getNivelTransporte() {
        return nivelTransporte;
    }
    
    public void setNivelTransporte(String nivelTransporte) {
        this.nivelTransporte = nivelTransporte;
    }
    
    public String getNombreRestaurante() {
        return nombreRestaurante;
    }
    
    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }
    
    public Double getPesoCarga() {
        return pesoCarga;
    }
    
    public void setPesoCarga(Double pesoCarga) {
        this.pesoCarga = pesoCarga;
    }
}
