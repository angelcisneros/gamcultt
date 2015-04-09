/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaEvento;

/**
 *
 * @author Lap_christo
 */
public interface GaleriaEventoServicio {
    String agregar(GaleriaEvento galeriaEvento);
    String actualizar(GaleriaEvento galeriaEvento);
    String eliminar(GaleriaEvento galeriaEvento);
    String eliminar(Integer id);
    
    GaleriaEvento buscarPorId(Integer id);
    List<GaleriaEvento> buscarTodos();
}
