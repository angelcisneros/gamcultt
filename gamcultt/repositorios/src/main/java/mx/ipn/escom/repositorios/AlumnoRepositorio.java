/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.Alumno;

/**
 *
 * @author Lap_christo
 */

public interface AlumnoRepositorio {
    
    Boolean agregar(Alumno alumno);
    Boolean actualizar(Alumno alumno);
    Boolean eliminar(Alumno alumno);
    Boolean eliminar(Integer id);
    
    Alumno buscarPorId(Integer id);
    List<Alumno> buscarTodos();
    
}
