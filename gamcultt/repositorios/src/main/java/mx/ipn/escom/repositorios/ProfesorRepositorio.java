/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.Profesor;

/**
 *
 * @author Lap_christo
 */

public interface ProfesorRepositorio {
    
    Boolean agregar(Profesor profesor);
    Boolean actualizar(Profesor profesor);
    Boolean eliminar(Profesor profesor);
    Boolean eliminar(Integer id);
    
    Profesor buscarPorId(Integer id);
    List<Profesor> buscarTodos();
    
}
