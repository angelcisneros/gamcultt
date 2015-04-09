/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.Evento;
import mx.ipn.escom.servicios.EventoServicio;
import static mx.ipn.escom.servicios.util.MensajesCrud.ERROR_DATOS;
import static mx.ipn.escom.servicios.util.MensajesCrud.SESION_CADUCA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vcisneros
 */
@Controller
public class EventoController {

    @Autowired
    EventoServicio eventoServicio;

    @ResponseBody
    @RequestMapping(value = "agregarEvento", method = RequestMethod.POST)
    public String agregarEvento(@Valid @ModelAttribute("evento") Evento evento, MultipartFile formato, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return eventoServicio.agregar(evento);
    }

    @ResponseBody
    @RequestMapping(value = "editarEvento", method = RequestMethod.POST)
    public String editarEvento(@Valid @ModelAttribute("evento") Evento evento, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return eventoServicio.actualizar(evento);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarEvento", method = RequestMethod.POST)
    public String eliminarEvento(Evento evento, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return eventoServicio.eliminar(evento);
    }
}
