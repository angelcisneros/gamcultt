/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.CasaHasTaller;
import mx.ipn.escom.servicios.CasaHasTallerServicio;
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
public class CasaHasTallerController{

    @Autowired
    CasaHasTallerServicio casaHasTallerServicio;

    @ResponseBody
    @RequestMapping(value = "agregarCasaHasTaller", method = RequestMethod.POST)
    public String agregarCasaHasTaller(@Valid @ModelAttribute("casaHasTaller") CasaHasTaller casaHasTaller, MultipartFile formato, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return casaHasTallerServicio.agregar(casaHasTaller);
    }

    @ResponseBody
    @RequestMapping(value = "editarCasaHasTaller", method = RequestMethod.POST)
    public String editarCasaHasTaller(@Valid @ModelAttribute("casaHasTaller") CasaHasTaller casaHasTaller, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return casaHasTallerServicio.actualizar(casaHasTaller);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarCasaHasTaller", method = RequestMethod.POST)
    public String eliminarCasaHasTaller(CasaHasTaller casaHasTaller, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return casaHasTallerServicio.eliminar(casaHasTaller);
    }
}
