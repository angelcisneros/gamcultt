/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.util;

import java.io.File;
import static mx.ipn.escom.servicios.util.Rutas.SERVER;
import static mx.ipn.escom.servicios.util.Rutas.USUARIOS;

/**
 *
 * @author vcisneros
 */
public class CarpetaArchivos {

    public static boolean crearCarpetaArchivosUsuarios(String mail) {
        File file = new File(USUARIOS + mail);
        return file.mkdir();

    }

    public static boolean aditarCarpetaArchivosUsuarios(String antiguo, String nuevo) {
        File file = new File(SERVER + "usuarios/" + antiguo);
        return file.renameTo(new File(SERVER + "usuarios/" + nuevo));
    }
}
