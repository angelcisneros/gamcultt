/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.Profesor;

/**
 *
 * @author Lap_christo
 */
public interface ProfesorServicio {
    String agregar(Profesor profesor);
    String actualizar(Profesor profesor);
    String eliminar(Profesor profesor);
    String eliminar(Integer id);
    
    Profesor buscarPorId(Integer id);
    List<Profesor> buscarTodos();
}
