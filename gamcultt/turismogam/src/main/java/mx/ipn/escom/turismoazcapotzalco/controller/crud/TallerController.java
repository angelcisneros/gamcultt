/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.Taller;
import mx.ipn.escom.servicios.TallerServicio;
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
public class TallerController {

    @Autowired
    TallerServicio tallerServicio;

    @ResponseBody
    @RequestMapping(value = "agregarTaller", method = RequestMethod.POST)
    public String agregarTaller(@Valid @ModelAttribute("taller") Taller taller, MultipartFile formato, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return tallerServicio.agregar(taller);
    }

    @ResponseBody
    @RequestMapping(value = "editarTaller", method = RequestMethod.POST)
    public String editarTaller(@Valid @ModelAttribute("taller") Taller taller, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return tallerServicio.actualizar(taller);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarTaller", method = RequestMethod.POST)
    public String eliminarTaller(Taller taller, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return tallerServicio.eliminar(taller);
    }
}
