/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.Sala;

/**
 *
 * @author Lap_christo
 */

public interface SalaRepositorio {
    
    Boolean agregar(Sala sala);
    Boolean actualizar(Sala sala);
    Boolean eliminar(Sala sala);
    Boolean eliminar(Integer id);
    
    Sala buscarPorId(Integer id);
    List<Sala> buscarTodos();
    
}
