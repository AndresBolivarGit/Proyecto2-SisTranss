package com.sistrans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sistrans.entity.SolicitudServicio;
import com.sistrans.entity.Servicio;
import com.sistrans.service.ServicioService;
import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @PostMapping("/solicitar")
    public ResponseEntity<Object> solicitarServicio(@RequestBody SolicitudServicio solicitud) {
        try {
            Servicio nuevoServicio = servicioService.crearServicio(solicitud);
            return new ResponseEntity<>(nuevoServicio, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}/finalizar")
    public ResponseEntity<Object> finalizarServicio(@PathVariable Long id, @RequestBody FinalizarServicioRequest request) {
        try {
            servicioService.finalizarServicio(id, request.getDistancia(), request.getCostoTotal());
            return new ResponseEntity<>("Servicio finalizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public static class FinalizarServicioRequest {
        private String distancia;
        @JsonProperty("costo_total")
        private Double costoTotal;

        public String getDistancia() {
            return distancia;
        }

        public void setDistancia(String distancia) {
            this.distancia = distancia;
        }

        public Double getCostoTotal() {
            return costoTotal;
        }

        public void setCostoTotal(Double costoTotal) {
            this.costoTotal = costoTotal;
        }
    }
}
