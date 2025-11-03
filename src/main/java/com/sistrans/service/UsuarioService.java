package com.sistrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistrans.dto.UsuarioServicioDTO;
import com.sistrans.dto.TarjetaCreditoDTO;
import com.sistrans.dto.UsuarioConductorDTO;
import com.sistrans.entity.Usuario;
import com.sistrans.entity.TarjetaCredito;
import com.sistrans.repository.UsuarioRepository;
import com.sistrans.exception.AppLogicException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void crearUsuarioServicio(UsuarioServicioDTO usuarioServicioDTO) {
        if (usuarioServicioDTO.getCedula() == null) {
            throw new AppLogicException("La cédula es requerida");
        }
        if (usuarioServicioDTO.getNombre() == null || usuarioServicioDTO.getNombre().trim().isEmpty()) {
            throw new AppLogicException("El nombre es requerido");
        }
        if (usuarioServicioDTO.getCorreo() == null || usuarioServicioDTO.getCorreo().trim().isEmpty()) {
            throw new AppLogicException("El correo es requerido");
        }
        
        Usuario usuario = new Usuario();
        usuario.setCedula(usuarioServicioDTO.getCedula());
        usuario.setNombre(usuarioServicioDTO.getNombre());
        usuario.setCorreo(usuarioServicioDTO.getCorreo());
        usuario.setCelular(usuarioServicioDTO.getCelular());
        usuario.setRol("SERVICIOS");
        
        usuarioRepository.insertarUsuario(usuario);
        
        if (usuarioServicioDTO.getTarjetaCredito() != null) {
            TarjetaCreditoDTO t = usuarioServicioDTO.getTarjetaCredito();
            TarjetaCredito tarjeta = new TarjetaCredito();
            tarjeta.setUsuarioCedula(usuarioServicioDTO.getCedula());
            tarjeta.setNumero(t.getNumero());
            tarjeta.setNombreTarjeta(t.getNombreTarjeta());
            tarjeta.setFechaVencimiento(t.getFechaVencimiento());
            tarjeta.setCodigoSeguridad(t.getCodigoSeguridad());
            usuarioRepository.insertarTarjetaCredito(tarjeta);
        }

    }

    public void crearUsuarioConductor(UsuarioConductorDTO usuarioConductorDTO) {
        if (usuarioConductorDTO.getCedula() == null) {
            throw new AppLogicException("La cédula es requerida");
        }
        if (usuarioConductorDTO.getNombre() == null || usuarioConductorDTO.getNombre().trim().isEmpty()) {
            throw new AppLogicException("El nombre es requerido");
        }
        if (usuarioConductorDTO.getCorreo() == null || usuarioConductorDTO.getCorreo().trim().isEmpty()) {
            throw new AppLogicException("El correo es requerido");
        }
        
        Usuario usuario = new Usuario();
        usuario.setCedula(usuarioConductorDTO.getCedula());
        usuario.setNombre(usuarioConductorDTO.getNombre());
        usuario.setCorreo(usuarioConductorDTO.getCorreo());
        usuario.setCelular(usuarioConductorDTO.getCelular());
        usuario.setRol("CONDUCTOR");
        
        usuarioRepository.insertarUsuario(usuario);
    }
}
