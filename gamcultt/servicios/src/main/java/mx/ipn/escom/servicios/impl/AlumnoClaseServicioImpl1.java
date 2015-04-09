/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.AlumnoClase;
import mx.ipn.escom.repositorios.AlumnoClaseRepositorio;
import mx.ipn.escom.servicios.AlumnoClaseServicio;
import static mx.ipn.escom.servicios.util.MensajesCrud.ADD_CORRECT;
import static mx.ipn.escom.servicios.util.MensajesCrud.DELETE_CORRECT;
import static mx.ipn.escom.servicios.util.MensajesCrud.ERROR_HIBERNATE;
import static mx.ipn.escom.servicios.util.MensajesCrud.UPDATE_CORRECT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Lap_christo
 */

@Service
public class AlumnoClaseServicioImpl1 implements AlumnoClaseServicio{
    
    @Autowired
    AlumnoClaseRepositorio alumnoClaseRepositorio;
    private static final String ALUMNO_CLASE = "un alumnoClase.#";
    
     @Override
    public String agregar(AlumnoClase alumnoClase) {
        if (alumnoClaseRepositorio.agregar(alumnoClase)) {
            return ADD_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(AlumnoClase alumnoClase) {
        if (alumnoClaseRepositorio.actualizar(alumnoClase)) {
            return UPDATE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(AlumnoClase alumnoClase) {
        if (alumnoClaseRepositorio.eliminar(alumnoClase)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<AlumnoClase> buscarTodos() {
        return alumnoClaseRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       AlumnoClase alumnoClase = alumnoClaseRepositorio.buscarPorId(id);
       if (alumnoClaseRepositorio.eliminar(alumnoClase)) {
            return DELETE_CORRECT + ALUMNO_CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public AlumnoClase buscarPorId(Integer id) {
       return alumnoClaseRepositorio.buscarPorId(id);
    }
}
