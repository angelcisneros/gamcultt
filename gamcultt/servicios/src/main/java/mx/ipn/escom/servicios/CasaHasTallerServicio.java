/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.CasaHasTaller;

/**
 *
 * @author Lap_christo
 */
public interface CasaHasTallerServicio {
    String agregar(CasaHasTaller alumno);
    String actualizar(CasaHasTaller alumno);
    String eliminar(CasaHasTaller alumno);
    String eliminar(Integer id);
    
    CasaHasTaller buscarPorId(Integer id);
    List<CasaHasTaller> buscarTodos();
}
