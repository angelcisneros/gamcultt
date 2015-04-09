/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller.crud;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mx.ipn.escom.entidades.GaleriaTaller;
import mx.ipn.escom.servicios.GaleriaTallerServicio;
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
public class GaleriaTallerController {

    @Autowired
    GaleriaTallerServicio galeriaTallerServicio;

    @ResponseBody
    @RequestMapping(value = "agregarGaleriaTaller", method = RequestMethod.POST)
    public String agregarGaleriaTaller(@Valid @ModelAttribute("galeriaTaller") GaleriaTaller galeriaTaller, MultipartFile formato, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return galeriaTallerServicio.agregar(galeriaTaller);
    }

    @ResponseBody
    @RequestMapping(value = "editarGaleriaTaller", method = RequestMethod.POST)
    public String editarGaleriaTaller(@Valid @ModelAttribute("galeriaTaller") GaleriaTaller galeriaTaller, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        if (bindingResult.hasErrors()) {
            return ERROR_DATOS;
        }
        return galeriaTallerServicio.actualizar(galeriaTaller);
    }

    @ResponseBody
    @RequestMapping(value = "eliminarGaleriaTaller", method = RequestMethod.POST)
    public String eliminarGaleriaTaller(GaleriaTaller galeriaTaller, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("usuario") == null){
            return SESION_CADUCA;
        }
        return galeriaTallerServicio.eliminar(galeriaTaller);
    }
}
