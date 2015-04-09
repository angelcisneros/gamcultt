/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.Clase;

/**
 *
 * @author Lap_christo
 */

public interface ClaseRepositorio {
    
    Boolean agregar(Clase clase);
    Boolean actualizar(Clase clase);
    Boolean eliminar(Clase clase);
    Boolean eliminar(Integer id);
    
    Clase buscarPorId(Integer id);
    List<Clase> buscarTodos();
    
}
