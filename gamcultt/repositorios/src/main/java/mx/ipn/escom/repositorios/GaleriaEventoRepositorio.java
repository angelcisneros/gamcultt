/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaEvento;

/**
 *
 * @author Lap_christo
 */

public interface GaleriaEventoRepositorio {
    
    Boolean agregar(GaleriaEvento galeriaEvento);
    Boolean actualizar(GaleriaEvento galeriaEvento);
    Boolean eliminar(GaleriaEvento galeriaEvento);
    Boolean eliminar(Integer id);
    
    GaleriaEvento buscarPorId(Integer id);
    List<GaleriaEvento> buscarTodos();
    
}
