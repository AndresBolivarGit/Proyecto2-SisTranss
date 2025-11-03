package com.sistrans.controller;

import com.sistrans.dto.Rfc1HistorialDTO;
import com.sistrans.dto.Rfc2TopConductorDTO;
import com.sistrans.dto.Rfc3GananciasVehiculoDTO;
import com.sistrans.dto.Rfc4UsoServicioDTO;
import com.sistrans.service.ReporteService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping("/api/rfc1")
public class ReporteController {

    private final ReporteService service;

    public ReporteController(ReporteService service) {
        this.service = service;
    }

    // GET /rfc1/read-committed?cedula=50001
    @GetMapping("/read-committed")
    public List<Rfc1HistorialDTO> rfc1ReadCommitted(@RequestParam Long cedula) {
        return service.rfc1ReadCommitted(cedula);
    }

    // GET /rfc1/serializable?cedula=50001
    @GetMapping("/serializable")
    public List<Rfc1HistorialDTO> rfc1Serializable(@RequestParam Long cedula) {
        return service.rfc1Serializable(cedula);
    }

    @GetMapping("/rfc2/top-conductores")
    public List<Rfc2TopConductorDTO> rfc2(@RequestParam(required = false) Integer limite){
        return service.rfc2(limite);
    }

    @GetMapping("/rfc3/ganancias-conductor/{cedulaConductor}")
    public List<Rfc3GananciasVehiculoDTO> rfc3(@PathVariable String cedulaConductor){
        return service.rfc3(cedulaConductor);
    }

    @GetMapping("/rfc4/uso-servicios")
    public List<Rfc4UsoServicioDTO> rfc4(
        @RequestParam(required = false) String desde,
        @RequestParam(required = false) String hasta) {

    LocalDateTime d = parseLdt(desde);
    LocalDateTime h = parseLdt(hasta);
    return service.rfc4(d, h);
    }

    private static LocalDateTime parseLdt(String s) {
        if (s == null || s.isBlank()) return null;
        s = s.trim().replace(' ', 'T'); 
        return LocalDateTime.parse(s, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
