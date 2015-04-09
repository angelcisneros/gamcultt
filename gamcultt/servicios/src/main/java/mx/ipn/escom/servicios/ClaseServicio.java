/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.Clase;

/**
 *
 * @author Lap_christo
 */
public interface ClaseServicio {
    String agregar(Clase clase);
    String actualizar(Clase clase);
    String eliminar(Clase clase);
    String eliminar(Integer id);
    
    Clase buscarPorId(Integer id);
    List<Clase> buscarTodos();
}
