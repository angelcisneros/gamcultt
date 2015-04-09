/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.GaleriaEvento;
import mx.ipn.escom.servicios.GaleriaEventoServicio;
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
public class GaleriaEventoController {

    @Autowired
    GaleriaEventoServicio galeriaEventoServicio;

    @ResponseBody
    @RequestMapping(value = "agregarGaleriaEvento", method = RequestMethod.POST)
    public String agregarGaleriaEvento(@Valid @ModelAttribute("galeriaEvento") GaleriaEvento galeriaEvento, MultipartFile formato, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return galeriaEventoServicio.agregar(galeriaEvento);
    }

    @ResponseBody
    @RequestMapping(value = "editarGaleriaEvento", method = RequestMethod.POST)
    public String editarGaleriaEvento(@Valid @ModelAttribute("galeriaEvento") GaleriaEvento galeriaEvento, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return galeriaEventoServicio.actualizar(galeriaEvento);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarGaleriaEvento", method = RequestMethod.POST)
    public String eliminarGaleriaEvento(GaleriaEvento galeriaEvento, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return galeriaEventoServicio.eliminar(galeriaEvento);
    }
}
