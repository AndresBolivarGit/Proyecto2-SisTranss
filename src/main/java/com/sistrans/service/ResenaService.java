package com.sistrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistrans.dto.ResenaDTO;
import com.sistrans.entity.Resena;
import com.sistrans.repository.ResenaRepository;
import com.sistrans.exception.AppLogicException;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    public void crearResena(ResenaDTO resenaDTO) {
        if (resenaDTO.getCedulaAutor() == null) {
            throw new AppLogicException("La cédula del autor es requerida");
        }
        if (resenaDTO.getCedulaEvaluado() == null) {
            throw new AppLogicException("La cédula del evaluado es requerida");
        }
        if (resenaDTO.getIdServicio() == null) {
            throw new AppLogicException("El ID del servicio es requerido");
        }
        if (resenaDTO.getEvaluacionNum() == null || resenaDTO.getEvaluacionNum() < 0 || resenaDTO.getEvaluacionNum() > 5) {
            throw new AppLogicException("La evaluación debe ser un número entre 0 y 5");
        }
        
        String rolUsuario = resenaRepository.obtenerRolUsuario(resenaDTO.getCedulaAutor());
        
        if (rolUsuario == null) {
            throw new AppLogicException("El usuario no existe en el sistema");
        }
        
        if ("SERVICIOS".equals(rolUsuario)) {
            crearResenaServicio(resenaDTO);
        } else if ("CONDUCTOR".equals(rolUsuario)) {
            crearResenaConductor(resenaDTO);
        } else {
            throw new AppLogicException("Rol de usuario no válido para crear reseñas");
        }
    }

    private void crearResenaServicio(ResenaDTO resenaDTO) {
        if (!resenaRepository.verificarSolicitanteServicio(resenaDTO.getCedulaAutor(), resenaDTO.getIdServicio())) {
            throw new AppLogicException("El usuario no solicitó este servicio");
        }

        Resena resena = new Resena();
        resena.setEvaluacionNum(resenaDTO.getEvaluacionNum());
        resena.setComentario(resenaDTO.getComentario());
        resena.setCedulaAutor(resenaDTO.getCedulaAutor());
        resena.setCedulaEvaluado(resenaDTO.getCedulaEvaluado());
        resena.setIdServicio(resenaDTO.getIdServicio());
        
        resenaRepository.insertarResena(resena);
    }

    private void crearResenaConductor(ResenaDTO resenaDTO) {
        if (!resenaRepository.verificarConductorServicio(resenaDTO.getCedulaAutor(), resenaDTO.getIdServicio())) {
            throw new AppLogicException("El usuario no fue el conductor de este servicio");
        }

        Resena resena = new Resena();
        resena.setEvaluacionNum(resenaDTO.getEvaluacionNum());
        resena.setComentario(resenaDTO.getComentario());
        resena.setCedulaAutor(resenaDTO.getCedulaAutor());
        resena.setCedulaEvaluado(resenaDTO.getCedulaEvaluado());
        resena.setIdServicio(resenaDTO.getIdServicio());
        
        resenaRepository.insertarResena(resena);
    }
}
