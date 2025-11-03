package com.sistrans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistrans.dto.*;
import com.sistrans.entity.SolicitudServicio;
import com.sistrans.service.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Controller
public class WebController {

    @Autowired
    private CiudadService ciudadService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private VehiculoService vehiculoService;
    
    @Autowired
    private DisponibilidadService disponibilidadService;
    
    @Autowired
    private PuntoTrayectoService puntoTrayectoService;
    
    @Autowired
    private ServicioService servicioService;
    
    @Autowired
    private ResenaService resenaService;
    
    @Autowired
    private ReporteService reporteService;

    // ============== PÁGINAS PRINCIPALES ==============
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/rf")
    public String requisitos() {
        return "rf/index";
    }
    
    @GetMapping("/rfc")
    public String consultas() {
        return "rfc/index";
    }
    
    // ============== RF1 - REGISTRAR CIUDAD ==============
    
    @GetMapping("/rf/ciudad")
    public String ciudadForm(Model model) {
        model.addAttribute("ciudad", new CiudadDTO());
        return "rf/ciudad";
    }
    
    @PostMapping("/rf/ciudad")
    public String ciudadSubmit(@ModelAttribute CiudadDTO ciudad, RedirectAttributes redirectAttributes) {
        try {
            ciudadService.crearCiudad(ciudad.getNombre());
            redirectAttributes.addFlashAttribute("success", "Ciudad registrada exitosamente: " + ciudad.getNombre());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar ciudad: " + e.getMessage());
        }
        return "redirect:/rf/ciudad";
    }
    
    // ============== RF2 - USUARIO DE SERVICIOS ==============
    
    @GetMapping("/rf/usuario-servicio")
    public String usuarioServicioForm(Model model) {
        model.addAttribute("usuario", new UsuarioServicioDTO());
        return "rf/usuario-servicio";
    }
    
    @PostMapping("/rf/usuario-servicio")
    public String usuarioServicioSubmit(@ModelAttribute UsuarioServicioDTO usuario, 
                                       @RequestParam("numeroTarjeta") String numeroTarjeta,
                                       @RequestParam("nombreTarjeta") String nombreTarjeta,
                                       @RequestParam("fechaVencimiento") String fechaVencimiento,
                                       @RequestParam("codigoSeguridad") String codigoSeguridad,
                                       RedirectAttributes redirectAttributes) {
        try {
            TarjetaCreditoDTO tarjeta = new TarjetaCreditoDTO();
            tarjeta.setNumero(numeroTarjeta);
            tarjeta.setNombreTarjeta(nombreTarjeta);
            tarjeta.setFechaVencimiento(java.time.LocalDate.parse(fechaVencimiento));
            tarjeta.setCodigoSeguridad(codigoSeguridad);
            usuario.setTarjetaCredito(tarjeta);
            
            usuarioService.crearUsuarioServicio(usuario);
            redirectAttributes.addFlashAttribute("success", "Usuario de servicios registrado exitosamente: " + usuario.getNombre());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar usuario: " + e.getMessage());
        }
        return "redirect:/rf/usuario-servicio";
    }
    
    // ============== RF3 - USUARIO CONDUCTOR ==============
    
    @GetMapping("/rf/usuario-conductor")
    public String usuarioConductorForm(Model model) {
        model.addAttribute("usuario", new UsuarioConductorDTO());
        return "rf/usuario-conductor";
    }
    
    @PostMapping("/rf/usuario-conductor")
    public String usuarioConductorSubmit(@ModelAttribute UsuarioConductorDTO usuario, 
                                        RedirectAttributes redirectAttributes) {
        try {
            usuarioService.crearUsuarioConductor(usuario);
            redirectAttributes.addFlashAttribute("success", "Usuario conductor registrado exitosamente: " + usuario.getNombre());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar conductor: " + e.getMessage());
        }
        return "redirect:/rf/usuario-conductor";
    }
    
    // ============== RF4 - REGISTRAR VEHÍCULO ==============
    
    @GetMapping("/rf/vehiculo")
    public String vehiculoForm(Model model) {
        model.addAttribute("vehiculo", new VehiculoDTO());
        return "rf/vehiculo";
    }
    
    @PostMapping("/rf/vehiculo")
    public String vehiculoSubmit(@ModelAttribute VehiculoDTO vehiculo, 
                                RedirectAttributes redirectAttributes) {
        try {
            vehiculoService.crearVehiculo(vehiculo);
            redirectAttributes.addFlashAttribute("success", "Vehículo registrado exitosamente: " + vehiculo.getPlaca());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar vehículo: " + e.getMessage());
        }
        return "redirect:/rf/vehiculo";
    }
    
    // ============== RF5 - REGISTRAR DISPONIBILIDAD ==============
    
    @GetMapping("/rf/disponibilidad")
    public String disponibilidadForm(Model model) {
        model.addAttribute("disponibilidad", new DisponibilidadDTO());
        return "rf/disponibilidad";
    }
    
    @PostMapping("/rf/disponibilidad")
    public String disponibilidadSubmit(@ModelAttribute DisponibilidadDTO disponibilidad, 
                                      RedirectAttributes redirectAttributes) {
        try {
            Long id = disponibilidadService.crearDisponibilidad(disponibilidad);
            redirectAttributes.addFlashAttribute("success", "Disponibilidad registrada exitosamente con ID: " + id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar disponibilidad: " + e.getMessage());
        }
        return "redirect:/rf/disponibilidad";
    }
    
    // ============== RF6 - MODIFICAR DISPONIBILIDAD ==============
    
    @GetMapping("/rf/disponibilidad/modificar")
    public String disponibilidadModificarForm(Model model) {
        model.addAttribute("disponibilidad", new DisponibilidadDTO());
        return "rf/disponibilidad-modificar";
    }
    
    @PostMapping("/rf/disponibilidad/modificar")
    public String disponibilidadModificarSubmit(@ModelAttribute DisponibilidadDTO disponibilidad, 
                                               RedirectAttributes redirectAttributes) {
        try {
            disponibilidadService.modificarDisponibilidad(disponibilidad);
            redirectAttributes.addFlashAttribute("success", "Disponibilidad modificada exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al modificar disponibilidad: " + e.getMessage());
        }
        return "redirect:/rf/disponibilidad/modificar";
    }
    
    // ============== RF7 - PUNTO GEOGRÁFICO ==============
    
    @GetMapping("/rf/punto")
    public String puntoForm(Model model) {
        model.addAttribute("punto", new PuntoTrayectoDTO());
        return "rf/punto";
    }
    
    @PostMapping("/rf/punto")
    public String puntoSubmit(@ModelAttribute PuntoTrayectoDTO punto, 
                             RedirectAttributes redirectAttributes) {
        try {
            Long id = puntoTrayectoService.crearPuntoTrayecto(punto);
            redirectAttributes.addFlashAttribute("success", "Punto geográfico registrado exitosamente con ID: " + id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar punto: " + e.getMessage());
        }
        return "redirect:/rf/punto";
    }
    
    // ============== RF8 - SOLICITAR SERVICIO ==============
    
    @GetMapping("/rf/servicio")
    public String servicioForm(Model model) {
        model.addAttribute("solicitud", new SolicitudServicio());
        return "rf/servicio";
    }
    
    @PostMapping("/rf/servicio")
    public String servicioSubmit(@ModelAttribute SolicitudServicio solicitud, 
                                @RequestParam("destino") String destino,
                                RedirectAttributes redirectAttributes) {
        try {
            solicitud.setIdsPuntosDestino(Arrays.asList(Long.parseLong(destino)));
            var servicio = servicioService.crearServicio(solicitud);
            redirectAttributes.addFlashAttribute("success", "Servicio creado exitosamente con ID: " + servicio.getId());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al crear servicio: " + e.getMessage());
        }
        return "redirect:/rf/servicio";
    }
    
    // ============== RF9 - FINALIZAR SERVICIO ==============
    
    @GetMapping("/rf/servicio/finalizar")
    public String servicioFinalizarForm(Model model) {
        return "rf/servicio-finalizar";
    }
    
    @PostMapping("/rf/servicio/finalizar")
    public String servicioFinalizarSubmit(@RequestParam("idServicio") Long idServicio,
                                         @RequestParam("distancia") String distancia,
                                         @RequestParam("costoTotal") Double costoTotal,
                                         RedirectAttributes redirectAttributes) {
        try {
            servicioService.finalizarServicio(idServicio, distancia, costoTotal);
            redirectAttributes.addFlashAttribute("success", "Servicio finalizado exitosamente: ID " + idServicio);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al finalizar servicio: " + e.getMessage());
        }
        return "redirect:/rf/servicio/finalizar";
    }
    
    // ============== RF10 - RESEÑA USUARIO A CONDUCTOR ==============
    
    @GetMapping("/rf/resena/usuario")
    public String resenaUsuarioForm(Model model) {
        model.addAttribute("resena", new ResenaDTO());
        return "rf/resena-usuario";
    }
    
    @PostMapping("/rf/resena/usuario")
    public String resenaUsuarioSubmit(@ModelAttribute ResenaDTO resena, 
                                     RedirectAttributes redirectAttributes) {
        try {
            resenaService.crearResena(resena);
            redirectAttributes.addFlashAttribute("success", "Reseña registrada exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar reseña: " + e.getMessage());
        }
        return "redirect:/rf/resena/usuario";
    }
    
    // ============== RF11 - RESEÑA CONDUCTOR A USUARIO ==============
    
    @GetMapping("/rf/resena/conductor")
    public String resenaConductorForm(Model model) {
        model.addAttribute("resena", new ResenaDTO());
        return "rf/resena-conductor";
    }
    
    @PostMapping("/rf/resena/conductor")
    public String resenaConductorSubmit(@ModelAttribute ResenaDTO resena, 
                                       RedirectAttributes redirectAttributes) {
        try {
            resenaService.crearResena(resena);
            redirectAttributes.addFlashAttribute("success", "Reseña registrada exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar reseña: " + e.getMessage());
        }
        return "redirect:/rf/resena/conductor";
    }
    
    // ============== RFC1 - HISTORIAL DE SERVICIOS ==============
    
    @GetMapping("/rfc/historial")
    public String historialForm(Model model) {
        return "rfc/historial";
    }
    
    @PostMapping("/rfc/historial")
    public String historialSubmit(@RequestParam("cedula") Long cedula,
                                  @RequestParam("limite") Integer limite,
                                  Model model) {
        try {
            var historial = reporteService.rfc1ReadCommitted(cedula);
            model.addAttribute("historial", historial);
            model.addAttribute("cedula", cedula);
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("error", "Error al obtener historial: " + e.getMessage());
        }
        return "rfc/historial";
    }
    
    // ============== RFC2 - TOP 10 CONDUCTORES ==============
    
    @GetMapping("/rfc/top-conductores")
    public String topConductores(Model model) {
        try {
            var topConductores = reporteService.rfc2(10);
            model.addAttribute("conductores", topConductores);
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("error", "Error al obtener datos: " + e.getMessage());
        }
        return "rfc/top-conductores";
    }
    
    // ============== RFC3 - GANANCIAS POR VEHÍCULO ==============
    
    @GetMapping("/rfc/ganancias")
    public String gananciasForm(Model model) {
        return "rfc/ganancias";
    }
    
    @PostMapping("/rfc/ganancias")
    public String gananciasSubmit(@RequestParam("cedulaConductor") String cedulaConductor,
                                 Model model) {
        try {
            var ganancias = reporteService.rfc3(cedulaConductor);
            model.addAttribute("ganancias", ganancias);
            model.addAttribute("cedulaConductor", cedulaConductor);
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("error", "Error al obtener ganancias: " + e.getMessage());
        }
        return "rfc/ganancias";
    }
    
    // ============== RFC4 - USO DEL SERVICIO ==============
    
    @GetMapping("/rfc/uso-servicio")
    public String usoServicioForm(Model model) {
        return "rfc/uso-servicio";
    }
    
    @PostMapping("/rfc/uso-servicio")
    public String usoServicioSubmit(@RequestParam("desde") String desde,
                                   @RequestParam("hasta") String hasta,
                                   Model model) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime desdeDate = LocalDateTime.parse(desde, formatter);
            LocalDateTime hastaDate = LocalDateTime.parse(hasta, formatter);
            
            var usoServicio = reporteService.rfc4(desdeDate, hastaDate);
            model.addAttribute("usoServicio", usoServicio);
            model.addAttribute("desde", desde);
            model.addAttribute("hasta", hasta);
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("error", "Error al obtener estadísticas: " + e.getMessage());
        }
        return "rfc/uso-servicio";
    }
}