/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaCasa;

/**
 *
 * @author Lap_christo
 */

public interface GaleriaCasaRepositorio {
    
    Boolean agregar(GaleriaCasa galeriaCasa);
    Boolean actualizar(GaleriaCasa galeriaCasa);
    Boolean eliminar(GaleriaCasa galeriaCasa);
    Boolean eliminar(Integer id);
    
    GaleriaCasa buscarPorId(Integer id);
    List<GaleriaCasa> buscarTodos();
    
}
