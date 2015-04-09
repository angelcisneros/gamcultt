/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.Propuesta;

/**
 *
 * @author Lap_christo
 */

public interface PropuestaRepositorio {
    
    Boolean agregar(Propuesta propuesta);
    Boolean actualizar(Propuesta propuesta);
    Boolean eliminar(Propuesta propuesta);
    Boolean eliminar(Integer id);
    
    Propuesta buscarPorId(Integer id);
    List<Propuesta> buscarTodos();
    
}
