/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.GaleriaCasa;
import mx.ipn.escom.servicios.GaleriaCasaServicio;
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
public class GaleriaCasaController {

    @Autowired
    GaleriaCasaServicio galeriaCasaServicio;

    @ResponseBody
    @RequestMapping(value = "agregarGaleriaCasa", method = RequestMethod.POST)
    public String agregarGaleriaCasa(@Valid @ModelAttribute("galeriaCasa") GaleriaCasa galeriaCasa, MultipartFile formato, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return galeriaCasaServicio.agregar(galeriaCasa);
    }

    @ResponseBody
    @RequestMapping(value = "editarGaleriaCasa", method = RequestMethod.POST)
    public String editarGaleriaCasa(@Valid @ModelAttribute("galeriaCasa") GaleriaCasa galeriaCasa, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return galeriaCasaServicio.actualizar(galeriaCasa);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarGaleriaCasa", method = RequestMethod.POST)
    public String eliminarGaleriaCasa(GaleriaCasa galeriaCasa, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return galeriaCasaServicio.eliminar(galeriaCasa);
    }
}
