package com.sistrans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistrans.dto.PuntoTrayectoDTO;
import com.sistrans.service.PuntoTrayectoService;

@RestController
@RequestMapping("/puntos")
public class PuntoTrayectoController {

    @Autowired
    private PuntoTrayectoService puntoTrayectoService;

    @PostMapping
    public ResponseEntity<Object> crearPuntoTrayecto(@RequestBody PuntoTrayectoDTO puntoTrayectoDTO) {
        try {
            Long idPunto = puntoTrayectoService.crearPuntoTrayecto(puntoTrayectoDTO);
            return new ResponseEntity<>("Punto de trayecto creado con ID: " + idPunto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
