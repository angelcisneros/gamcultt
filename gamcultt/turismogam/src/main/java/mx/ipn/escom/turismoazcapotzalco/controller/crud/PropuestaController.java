/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.Propuesta;
import mx.ipn.escom.servicios.PropuestaServicio;
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
public class PropuestaController {

    @Autowired
    PropuestaServicio propuestaServicio;

    @ResponseBody
    @RequestMapping(value = "agregarPropuesta", method = RequestMethod.POST)
    public String agregarPropuesta(@Valid @ModelAttribute("propuesta") Propuesta propuesta, MultipartFile formato, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return propuestaServicio.agregar(propuesta);
    }

    @ResponseBody
    @RequestMapping(value = "editarPropuesta", method = RequestMethod.POST)
    public String editarPropuesta(@Valid @ModelAttribute("propuesta") Propuesta propuesta, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return propuestaServicio.actualizar(propuesta);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarPropuesta", method = RequestMethod.POST)
    public String eliminarPropuesta(Propuesta propuesta, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return propuestaServicio.eliminar(propuesta);
    }
}
