/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.Clase;
import mx.ipn.escom.servicios.ClaseServicio;
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
public class ClaseController {

    @Autowired
    ClaseServicio claseServicio;

    @ResponseBody
    @RequestMapping(value = "agregarClase", method = RequestMethod.POST)
    public String agregarClase(@Valid @ModelAttribute("clase") Clase clase, MultipartFile formato, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return claseServicio.agregar(clase);
    }

    @ResponseBody
    @RequestMapping(value = "editarClase", method = RequestMethod.POST)
    public String editarClase(@Valid @ModelAttribute("clase") Clase clase, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return claseServicio.actualizar(clase);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarClase", method = RequestMethod.POST)
    public String eliminarClase(Clase clase, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return claseServicio.eliminar(clase);
    }
}
