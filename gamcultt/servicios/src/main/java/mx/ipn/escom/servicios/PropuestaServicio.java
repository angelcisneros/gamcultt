/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.Propuesta;

/**
 *
 * @author Lap_christo
 */
public interface PropuestaServicio {
    String agregar(Propuesta propuesta);
    String actualizar(Propuesta propuesta);
    String eliminar(Propuesta propuesta);
    String eliminar(Integer id);
    
    Propuesta buscarPorId(Integer id);
    List<Propuesta> buscarTodos();
}
