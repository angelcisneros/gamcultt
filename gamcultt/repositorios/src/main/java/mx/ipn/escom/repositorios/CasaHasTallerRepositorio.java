/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.CasaHasTaller;

/**
 *
 * @author Lap_christo
 */

public interface CasaHasTallerRepositorio{
    
    Boolean agregar(CasaHasTaller casaHasTaller);
    Boolean actualizar(CasaHasTaller casaHasTaller);
    Boolean eliminar(CasaHasTaller casaHasTaller);
    Boolean eliminar(Integer id);
    
    CasaHasTaller buscarPorId(Integer id);
    List<CasaHasTaller> buscarTodos();
    
}
