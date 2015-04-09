/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.turismoazcapotzalco.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vcisneros
 */
@Controller
public class HomeController {
    

    @RequestMapping(value = "/")
    public String homeController() {
        return "templates/welcome";
    }

    @RequestMapping(value = "*")
    public String error404(HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "templates/index";
        }
        return "templates/404";
    }

    
   
}
