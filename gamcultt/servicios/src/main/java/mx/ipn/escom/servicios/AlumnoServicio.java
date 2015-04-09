/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.Alumno;

/**
 *
 * @author Lap_christo
 */
public interface AlumnoServicio {
    String agregar(Alumno alumno);
    String actualizar(Alumno alumno);
    String eliminar(Alumno alumno);
    String eliminar(Integer id);
    
    Alumno buscarPorId(Integer id);
    List<Alumno> buscarTodos();
}
