/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.Casa;

/**
 *
 * @author Lap_christo
 */

public interface CasaRepositorio {
    
    Boolean agregar(Casa casa);
    Boolean actualizar(Casa casa);
    Boolean eliminar(Casa casa);
    Boolean eliminar(Integer id);
    
    Casa buscarPorId(Integer id);
    List<Casa> buscarTodos();
    
}
