/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.Casa;
import mx.ipn.escom.servicios.CasaServicio;
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
public class CasaController {

    @Autowired
    CasaServicio casaServicio;

    
    @RequestMapping(value = "casas", method = RequestMethod.GET)
        public String casas(Model model, HttpSession session) {
        model.addAttribute("casas", casaServicio.buscarTodos());
        return "crud/casa";
    }
    @ResponseBody
    @RequestMapping(value = "agregarCasa", method = RequestMethod.POST)
    public String agregarCasa(@Valid @ModelAttribute("casa") Casa casa,  BindingResult bindingResult, HttpSession session) {
//        if (session.getAttribute("usuario") == null){
//            return SESION_CADUCA;
//        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return casaServicio.agregar(casa);
    }

    @ResponseBody
    @RequestMapping(value = "editarCasa", method = RequestMethod.POST)
    public String editarCasa(@Valid @ModelAttribute("casa") Casa casa, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return casaServicio.actualizar(casa);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarCasa", method = RequestMethod.POST)
    public String eliminarCasa(Casa casa, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return casaServicio.eliminar(casa);
    }
}
