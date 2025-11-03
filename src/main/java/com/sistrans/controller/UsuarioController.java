package com.sistrans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistrans.dto.UsuarioServicioDTO;
import com.sistrans.dto.UsuarioConductorDTO;
import com.sistrans.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/servicios")
    public ResponseEntity<Object> crearUsuarioServicio(@RequestBody UsuarioServicioDTO usuarioServicioDTO) {
        try {
            usuarioService.crearUsuarioServicio(usuarioServicioDTO);
            return new ResponseEntity<>("Usuario de servicios creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/conductores")
    public ResponseEntity<Object> crearUsuarioConductor(@RequestBody UsuarioConductorDTO usuarioConductorDTO) {
        try {
            usuarioService.crearUsuarioConductor(usuarioConductorDTO);
            return new ResponseEntity<>("Usuario conductor creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
