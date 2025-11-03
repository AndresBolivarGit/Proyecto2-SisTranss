package com.sistrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistrans.dto.PuntoTrayectoDTO;
import com.sistrans.entity.PuntoTrayecto;
import com.sistrans.repository.PuntoTrayectoRepository;

@Service
public class PuntoTrayectoService {

    @Autowired
    private PuntoTrayectoRepository puntoTrayectoRepository;

    public Long crearPuntoTrayecto(PuntoTrayectoDTO puntoTrayectoDTO) {
        PuntoTrayecto punto = new PuntoTrayecto();
        punto.setDireccion(puntoTrayectoDTO.getDireccion());
        punto.setCiudad(puntoTrayectoDTO.getCiudad());
        punto.setCoordenadas(puntoTrayectoDTO.getCoordenadas());
        punto.setTipoPunto(puntoTrayectoDTO.getTipoPunto());
        
        return puntoTrayectoRepository.insertarPunto(punto);
    }
}
