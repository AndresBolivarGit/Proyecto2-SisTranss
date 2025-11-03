package com.sistrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistrans.dto.VehiculoDTO;
import com.sistrans.entity.Vehiculo;
import com.sistrans.repository.VehiculoRepository;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public void crearVehiculo(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca(vehiculoDTO.getPlaca());
        vehiculo.setTipo(vehiculoDTO.getTipo());
        vehiculo.setMarca(vehiculoDTO.getMarca());
        vehiculo.setModelo(vehiculoDTO.getModelo());
        vehiculo.setColor(vehiculoDTO.getColor());
        vehiculo.setCiudadPlaca(vehiculoDTO.getCiudadPlaca());
        vehiculo.setCapacidadPasajero(vehiculoDTO.getCapacidadPasajero());
        vehiculo.setNivelTransporte(vehiculoDTO.getNivelTransporte());
        vehiculo.setCedulaDueno(vehiculoDTO.getCedulaDueno());
        
        vehiculoRepository.insertarVehiculo(vehiculo);
    }
}
