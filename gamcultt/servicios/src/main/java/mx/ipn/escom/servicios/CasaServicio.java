/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.Casa;

/**
 *
 * @author Lap_christo
 */
public interface CasaServicio {
    String agregar(Casa casa);
    String actualizar(Casa casa);
    String eliminar(Casa casa);
    String eliminar(Integer id);
    
    Casa buscarPorId(Integer id);
    List<Casa> buscarTodos();
}
