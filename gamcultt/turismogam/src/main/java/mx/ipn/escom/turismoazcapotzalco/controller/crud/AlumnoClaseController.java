/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.AlumnoClase;
import mx.ipn.escom.servicios.AlumnoClaseServicio;
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
public class AlumnoClaseController {

    @Autowired
    AlumnoClaseServicio alumnoClaseServicio;

    @ResponseBody
    @RequestMapping(value = "agregarAlumnoClase", method = RequestMethod.POST)
    public String agregarAlumnoClase(@Valid @ModelAttribute("alumnoClase") AlumnoClase alumnoClase, MultipartFile formato, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return alumnoClaseServicio.agregar(alumnoClase);
    }

    @ResponseBody
    @RequestMapping(value = "editarAlumnoClase", method = RequestMethod.POST)
    public String editarAlumnoClase(@Valid @ModelAttribute("alumnoClase") AlumnoClase alumnoClase, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return alumnoClaseServicio.actualizar(alumnoClase);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarAlumnoClase", method = RequestMethod.POST)
    public String eliminarAlumnoClase(AlumnoClase alumnoClase, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return alumnoClaseServicio.eliminar(alumnoClase);
    }
}
