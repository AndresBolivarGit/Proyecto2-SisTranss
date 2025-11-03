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

import com.sistrans.dto.DisponibilidadDTO;
import com.sistrans.service.DisponibilidadService;

@RestController
@RequestMapping("/disponibilidad")
public class DisponibilidadController {

    @Autowired
    private DisponibilidadService disponibilidadService;

    @PostMapping
    public ResponseEntity<Object> crearDisponibilidad(@RequestBody DisponibilidadDTO disponibilidadDTO) {
        try {
            Long idDisponibilidad = disponibilidadService.crearDisponibilidad(disponibilidadDTO);
            return new ResponseEntity<>("Disponibilidad creada con ID: " + idDisponibilidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> modificarDisponibilidad(@PathVariable Long id, @RequestBody DisponibilidadDTO disponibilidadDTO) {
        try {
            disponibilidadDTO.setIdDisponibilidad(id);
            disponibilidadService.modificarDisponibilidad(disponibilidadDTO);
            return new ResponseEntity<>("Disponibilidad modificada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
