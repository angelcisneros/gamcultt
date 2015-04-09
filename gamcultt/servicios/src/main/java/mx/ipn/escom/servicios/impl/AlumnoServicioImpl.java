/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Alumno;
import mx.ipn.escom.repositorios.AlumnoRepositorio;
import mx.ipn.escom.servicios.AlumnoServicio;
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
public class AlumnoServicioImpl implements AlumnoServicio{
    
    @Autowired
    AlumnoRepositorio alumnoRepositorio;
    private static final String ALUMNO = "un alumno.#";
    
     @Override
    public String agregar(Alumno alumno) {
        if (alumnoRepositorio.agregar(alumno)) {
            return ADD_CORRECT + ALUMNO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Alumno alumno) {
        if (alumnoRepositorio.actualizar(alumno)) {
            return UPDATE_CORRECT + ALUMNO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Alumno alumno) {
        if (alumnoRepositorio.eliminar(alumno)) {
            return DELETE_CORRECT + ALUMNO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Alumno> buscarTodos() {
        return alumnoRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Alumno alumno = alumnoRepositorio.buscarPorId(id);
       if (alumnoRepositorio.eliminar(alumno)) {
            return DELETE_CORRECT + ALUMNO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Alumno buscarPorId(Integer id) {
       return alumnoRepositorio.buscarPorId(id);
    }
}
