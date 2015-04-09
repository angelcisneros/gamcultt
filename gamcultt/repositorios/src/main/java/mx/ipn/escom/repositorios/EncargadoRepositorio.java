/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.Encargado;

/**
 *
 * @author Lap_christo
 */

public interface EncargadoRepositorio {
    
    Boolean agregar(Encargado encargado);
    Boolean actualizar(Encargado encargado);
    Boolean eliminar(Encargado encargado);
    Boolean eliminar(Integer id);
    
    Encargado buscarPorId(Integer id);
    List<Encargado> buscarTodos();
    
}
