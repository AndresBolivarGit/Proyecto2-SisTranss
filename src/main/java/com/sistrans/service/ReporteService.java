package com.sistrans.service;

import com.sistrans.dto.Rfc1HistorialDTO;
import com.sistrans.dto.Rfc2TopConductorDTO;
import com.sistrans.dto.Rfc3GananciasVehiculoDTO;
import com.sistrans.dto.Rfc4UsoServicioDTO;
import com.sistrans.repository.RfcRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReporteService {

    private final RfcRepository repo;

    public ReporteService(RfcRepository repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE, timeout = 30)
    public List<Rfc1HistorialDTO> rfc1Serializable(Long cedula) {        
        return repo.rfc1Historial(cedula, 50);
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, timeout = 30)
    public List<Rfc1HistorialDTO> rfc1ReadCommitted(Long cedula) {
        return repo.rfc1Historial(cedula, 50);
    }

    public List<Rfc2TopConductorDTO> rfc2(Integer limite){
    return repo.rfc2TopConductores(limite);
    }

    public List<Rfc3GananciasVehiculoDTO> rfc3(String cedulaConductor){
    return repo.rfc3GananciasPorConductor(cedulaConductor);
    }

    public List<Rfc4UsoServicioDTO> rfc4(LocalDateTime desde, LocalDateTime hasta){
    return repo.rfc4UsoServicios(desde, hasta);
    }
}
