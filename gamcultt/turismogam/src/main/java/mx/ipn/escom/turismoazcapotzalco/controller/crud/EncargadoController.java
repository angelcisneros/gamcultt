/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.Encargado;
import mx.ipn.escom.servicios.EncargadoServicio;
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
public class EncargadoController {

    @Autowired
    EncargadoServicio encargadoServicio;

    @ResponseBody
    @RequestMapping(value = "agregarEncargado", method = RequestMethod.POST)
    public String agregarEncargado(@Valid @ModelAttribute("encargado") Encargado encargado, MultipartFile formato, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return encargadoServicio.agregar(encargado);
    }

    @ResponseBody
    @RequestMapping(value = "editarEncargado", method = RequestMethod.POST)
    public String editarEncargado(@Valid @ModelAttribute("encargado") Encargado encargado, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return encargadoServicio.actualizar(encargado);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarEncargado", method = RequestMethod.POST)
    public String eliminarEncargado(Encargado encargado, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return encargadoServicio.eliminar(encargado);
    }
}
