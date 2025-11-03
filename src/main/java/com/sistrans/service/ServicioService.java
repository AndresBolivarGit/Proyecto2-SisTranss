package com.sistrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistrans.entity.ConductorDisponible;
import com.sistrans.entity.Servicio;
import com.sistrans.exception.AppLogicException;
import com.sistrans.repository.ServicioRepository;
import com.sistrans.repository.UsuarioRepository;
import com.sistrans.entity.SolicitudServicio;

@Service
public class ServicioService {

    @Autowired private ServicioRepository servicioRepository;
    @Autowired private UsuarioRepository usuarioRepository;

    @Transactional
    public Servicio crearServicio(SolicitudServicio solicitud) {

        if (solicitud == null) throw new AppLogicException("Solicitud inválida");
        if (solicitud.getCedulaSolicitante() == null) throw new AppLogicException("Falta cédula del solicitante");
        if (solicitud.getTipoServicio() == null || solicitud.getTipoServicio().isBlank())
            throw new AppLogicException("Falta tipo de servicio");
        if (solicitud.getIdPuntoPartida() == null)
            throw new AppLogicException("Falta punto de partida");
        if (solicitud.getNumeroTarjeta() == null || solicitud.getNumeroTarjeta().isBlank())
            throw new AppLogicException("Debe indicar una tarjeta registrada para solicitar el servicio.");
        boolean tieneTarjeta = usuarioRepository.existeTarjetaPorUsuarioYNumero(
                solicitud.getCedulaSolicitante(), solicitud.getNumeroTarjeta());
        if (!tieneTarjeta)
            throw new AppLogicException("La tarjeta indicada no está registrada para el usuario.");

        String tipoVehiculo = mapearTipoServicioATipoVehiculo(solicitud.getTipoServicio());
        String nivel = normalizarNivelTransporte(solicitud.getNivelTransporte());

        ConductorDisponible conductor = servicioRepository
                .buscarConductorDisponiblePorTipoYNivel(tipoVehiculo, nivel);
        if (conductor == null)
            throw new AppLogicException("No hay conductores disponibles para este tipo/nivel.");

        double costoTotal = calcularCostoEstimado();

        Servicio s = new Servicio();
        s.setTipo(solicitud.getTipoServicio());
        s.setCedulaSolicitante(solicitud.getCedulaSolicitante());
        s.setCedulaConductor(conductor.getCedula());
        s.setPlacaVehiculo(conductor.getPlaca());
        s.setIdPuntoPartida(solicitud.getIdPuntoPartida());
        s.setTarjetaCredito(solicitud.getNumeroTarjeta());
        s.setFechaHoraInicio(java.time.LocalDateTime.now());
        s.setDistancia("5km");
        s.setCostoTotal(costoTotal);

        Long idNuevo = servicioRepository.insertarServicio(s);
        servicioRepository.actualizarHoraInicio(idNuevo);
        servicioRepository.bloquearConductor(conductor.getCedula());

        if (solicitud.getIdsPuntosDestino() != null) {
            for (Long idDestino : solicitud.getIdsPuntosDestino()) {
                servicioRepository.insertarDestino(idNuevo, idDestino);
            }
        }

        switch (solicitud.getTipoServicio().trim().toUpperCase()) {
            case "TRANSPORTE_PASAJEROS":
                if (solicitud.getNivelTransporte() == null)
                    throw new AppLogicException("El nivel de transporte es requerido.");
                servicioRepository.insertarTransportePasajeros(idNuevo, nivel);
                break;
            case "ENTREGA_COMIDA":
                if (solicitud.getNombreRestaurante() == null || solicitud.getNombreRestaurante().isBlank())
                    throw new AppLogicException("El nombre del restaurante es requerido.");
                servicioRepository.insertarEntregaComida(idNuevo, solicitud.getNombreRestaurante());
                break;
            case "TRANSPORTE_MERCANCIA":
                if (solicitud.getPesoCarga() == null || solicitud.getPesoCarga() <= 0)
                    throw new AppLogicException("El peso de la carga debe ser mayor a 0.");
                servicioRepository.insertarTransporteMercancia(idNuevo, solicitud.getPesoCarga());
                break;
            default:
                throw new AppLogicException("Tipo de servicio no válido.");
        }

        s.setId(idNuevo);
        return s;
    }

    public void finalizarServicio(Long idServicio, String distancia, Double costoTotal) {
    if (!servicioRepository.existeServicio(idServicio)) {
        throw new AppLogicException("El servicio con ID " + idServicio + " no existe");
    }

    servicioRepository.actualizarHoraFin(idServicio);

    servicioRepository.finalizarServicio(idServicio, distancia, costoTotal);

    servicioRepository.liberarConductorPorServicio(idServicio);
}

    private double calcularCostoEstimado() { return 20000.0; }

    private String normalizarNivelTransporte(String nivel) {
        if (nivel == null) return "ESTANDAR";
        String n = nivel.trim().toUpperCase();
        return (n.equals("ESTANDAR") || n.equals("CONFORT") || n.equals("LARGE")) ? n : "ESTANDAR";
    }

    private String mapearTipoServicioATipoVehiculo(String tipoServicio) {
        if (tipoServicio == null) return "carro";
        switch (tipoServicio.trim().toUpperCase()) {
            case "TRANSPORTE_PASAJEROS": return "carro";
            case "ENTREGA_COMIDA":       return "motocicleta";
            case "TRANSPORTE_MERCANCIA": return "PICKUP";
            default:                     return "carro";
        }
    }
}
