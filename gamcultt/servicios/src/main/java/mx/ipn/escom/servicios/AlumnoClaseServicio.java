/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.AlumnoClase;

/**
 *
 * @author Lap_christo
 */
public interface AlumnoClaseServicio {
    String agregar(AlumnoClase alumnoClase);
    String actualizar(AlumnoClase alumnoClase);
    String eliminar(AlumnoClase alumnoClase);
    String eliminar(Integer id);
    
    AlumnoClase buscarPorId(Integer id);
    List<AlumnoClase> buscarTodos();
}
