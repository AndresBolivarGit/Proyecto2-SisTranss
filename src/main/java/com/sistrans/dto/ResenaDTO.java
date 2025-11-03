package com.sistrans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResenaDTO {
    private Long id;
    @JsonProperty("evaluacion_num")
    private Integer evaluacionNum;
    private String comentario;
    @JsonProperty("cedula_autor")
    private Long cedulaAutor;
    @JsonProperty("cedula_evaluado")
    private Long cedulaEvaluado;
    @JsonProperty("id_servicio")
    private Long idServicio;

    public ResenaDTO() {}

    public ResenaDTO(Long id, Integer evaluacionNum, String comentario, Long cedulaAutor,
                    Long cedulaEvaluado, Long idServicio) {
        this.id = id;
        this.evaluacionNum = evaluacionNum;
        this.comentario = comentario;
        this.cedulaAutor = cedulaAutor;
        this.cedulaEvaluado = cedulaEvaluado;
        this.idServicio = idServicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEvaluacionNum() {
        return evaluacionNum;
    }

    public void setEvaluacionNum(Integer evaluacionNum) {
        this.evaluacionNum = evaluacionNum;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getCedulaAutor() {
        return cedulaAutor;
    }

    public void setCedulaAutor(Long cedulaAutor) {
        this.cedulaAutor = cedulaAutor;
    }

    public Long getCedulaEvaluado() {
        return cedulaEvaluado;
    }

    public void setCedulaEvaluado(Long cedulaEvaluado) {
        this.cedulaEvaluado = cedulaEvaluado;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }
}
