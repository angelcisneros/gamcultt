/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.Alumno;
import mx.ipn.escom.servicios.AlumnoServicio;
import static mx.ipn.escom.servicios.util.MensajesCrud.ERROR_DATOS;
import static mx.ipn.escom.servicios.util.MensajesCrud.SESION_CADUCA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class AlumnoController {

    @Autowired
    AlumnoServicio alumnoServicio;

    @RequestMapping(value = "alumnos", method = RequestMethod.GET)
    public String alumnos(Model model, HttpSession session) {
        model.addAttribute("alumnos", alumnoServicio.buscarTodos());
        return "crud/alumno";
    }
    
    @ResponseBody
    @RequestMapping(value = "agregarAlumno", method = RequestMethod.POST)
    public String agregarAlumno(@Valid @ModelAttribute("alumno") Alumno alumno, BindingResult bindingResult, HttpSession session) {
//        if (session.getAttribute("usuario") == null){
//            return SESION_CADUCA;
//        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return alumnoServicio.agregar(alumno);
    }

    @ResponseBody
    @RequestMapping(value = "editarAlumno", method = RequestMethod.POST)
    public String editarAlumno(@Valid @ModelAttribute("alumno") Alumno alumno, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return alumnoServicio.actualizar(alumno);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarAlumno", method = RequestMethod.POST)
    public String eliminarAlumno(Alumno alumno, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return alumnoServicio.eliminar(alumno);
    }
}
