/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaCasa;

/**
 *
 * @author Lap_christo
 */
public interface GaleriaCasaServicio {
    String agregar(GaleriaCasa galeriaCasa);
    String actualizar(GaleriaCasa galeriaCasa);
    String eliminar(GaleriaCasa galeriaCasa);
    String eliminar(Integer id);
    
    GaleriaCasa buscarPorId(Integer id);
    List<GaleriaCasa> buscarTodos();
}
