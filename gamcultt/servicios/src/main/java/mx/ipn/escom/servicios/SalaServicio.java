/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.Sala;

/**
 *
 * @author Lap_christo
 */
public interface SalaServicio {
    String agregar(Sala sala);
    String actualizar(Sala sala);
    String eliminar(Sala sala);
    String eliminar(Integer id);
    
    Sala buscarPorId(Integer id);
    List<Sala> buscarTodos();
}
