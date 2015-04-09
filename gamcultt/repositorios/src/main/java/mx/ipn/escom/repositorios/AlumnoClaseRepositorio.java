/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.AlumnoClase;

/**
 *
 * @author Lap_christo
 */

public interface AlumnoClaseRepositorio {
    
    Boolean agregar(AlumnoClase alumnoClase);
    Boolean actualizar(AlumnoClase alumnoClase);
    Boolean eliminar(AlumnoClase alumnoClase);
    Boolean eliminar(Integer id);
    
    AlumnoClase buscarPorId(Integer id);
    List<AlumnoClase> buscarTodos();
    
}
