/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaTaller;

/**
 *
 * @author Lap_christo
 */

public interface GaleriaTallerRepositorio {
    
    Boolean agregar(GaleriaTaller galeriaTaller);
    Boolean actualizar(GaleriaTaller galeriaTaller);
    Boolean eliminar(GaleriaTaller galeriaTaller);
    Boolean eliminar(Integer id);
    
    GaleriaTaller buscarPorId(Integer id);
    List<GaleriaTaller> buscarTodos();
    
}
