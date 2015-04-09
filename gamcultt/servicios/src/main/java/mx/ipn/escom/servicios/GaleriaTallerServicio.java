/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaTaller;

/**
 *
 * @author Lap_christo
 */
public interface GaleriaTallerServicio {
    String agregar(GaleriaTaller galeriaTaller);
    String actualizar(GaleriaTaller galeriaTaller);
    String eliminar(GaleriaTaller galeriaTaller);
    String eliminar(Integer id);
    
    GaleriaTaller buscarPorId(Integer id);
    List<GaleriaTaller> buscarTodos();
}
