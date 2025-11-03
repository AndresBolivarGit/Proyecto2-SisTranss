package com.sistrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistrans.dto.DisponibilidadDTO;
import com.sistrans.entity.Disponibilidad;
import com.sistrans.repository.DisponibilidadRepository;
import com.sistrans.exception.AppLogicException;

@Service
public class DisponibilidadService {

    @Autowired
    private DisponibilidadRepository disponibilidadRepository;

    @Transactional
    public Long crearDisponibilidad(DisponibilidadDTO disponibilidadDTO) {
        if (disponibilidadDTO.getCedulaConductor() == null) {
            throw new AppLogicException("La cédula del conductor es requerida para crear disponibilidad");
        }

        if (disponibilidadRepository.verificarSuperposicion(
                disponibilidadDTO.getCedulaConductor(), 
                disponibilidadDTO.getDia(),
                disponibilidadDTO.getFranjaHoraria(),
                null)) {
            throw new AppLogicException("Ya existe una disponibilidad con horarios superpuestos en el día indicado");
        }

        Disponibilidad disponibilidad = new Disponibilidad();
        disponibilidad.setDia(disponibilidadDTO.getDia());
        disponibilidad.setFranjaHoraria(disponibilidadDTO.getFranjaHoraria());
        disponibilidad.setTipoTransporte(disponibilidadDTO.getTipoTransporte());
        
        return disponibilidadRepository.insertarDisponibilidad(
            disponibilidad,
            disponibilidadDTO.getCedulaConductor(),
            disponibilidadDTO.getPlacaVehiculo()
        );
    }

    @Transactional
    public void modificarDisponibilidad(DisponibilidadDTO disponibilidadDTO) {
        if (disponibilidadDTO.getCedulaConductor() == null) {
            throw new AppLogicException("La cédula del conductor es requerida para modificar disponibilidad");
        }
        
        if (disponibilidadRepository.verificarSuperposicion(
                disponibilidadDTO.getCedulaConductor(),
                disponibilidadDTO.getDia(),
                disponibilidadDTO.getFranjaHoraria(),
                disponibilidadDTO.getIdDisponibilidad())) {
            throw new AppLogicException("Ya existe una disponibilidad con horarios superpuestos en el día indicado");
        }

        Disponibilidad disponibilidad = new Disponibilidad();
        disponibilidad.setIdDisponibilidad(disponibilidadDTO.getIdDisponibilidad());
        disponibilidad.setDia(disponibilidadDTO.getDia());
        disponibilidad.setFranjaHoraria(disponibilidadDTO.getFranjaHoraria());
        disponibilidad.setTipoTransporte(disponibilidadDTO.getTipoTransporte());
        
        disponibilidadRepository.actualizarDisponibilidad(
            disponibilidad,
            disponibilidadDTO.getCedulaConductor(),
            disponibilidadDTO.getPlacaVehiculo()
        );
    }
}
