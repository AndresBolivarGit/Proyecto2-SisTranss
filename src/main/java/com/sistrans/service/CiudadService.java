package com.sistrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistrans.repository.CiudadRepository;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public void crearCiudad(String nombre) {
        ciudadRepository.insertarCiudad(nombre);
    }
}
