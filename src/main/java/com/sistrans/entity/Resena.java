package com.sistrans.entity;

public class Resena {
    private Long id;
    private Integer evaluacionNum;
    private String comentario;
    private Long cedulaAutor;
    private Long cedulaEvaluado;
    private Long idServicio;

    public Resena() {}

    public Resena(Long id, Integer evaluacionNum, String comentario, Long cedulaAutor,
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
