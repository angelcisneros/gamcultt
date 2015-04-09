/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.Taller;

/**
 *
 * @author Lap_christo
 */

public interface TallerRepositorio {
    
    Boolean agregar(Taller taller);
    Boolean actualizar(Taller taller);
    Boolean eliminar(Taller taller);
    Boolean eliminar(Integer id);
    
    Taller buscarPorId(Integer id);
    List<Taller> buscarTodos();
    
}
