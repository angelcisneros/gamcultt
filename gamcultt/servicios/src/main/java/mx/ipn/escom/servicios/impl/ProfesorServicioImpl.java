/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Profesor;
import mx.ipn.escom.repositorios.ProfesorRepositorio;
import mx.ipn.escom.servicios.ProfesorServicio;
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
public class ProfesorServicioImpl implements ProfesorServicio{
    
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    private static final String PROFESOR = "un profesor.#";
    
     @Override
    public String agregar(Profesor profesor) {
        if (profesorRepositorio.agregar(profesor)) {
            return ADD_CORRECT + PROFESOR;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Profesor profesor) {
        if (profesorRepositorio.actualizar(profesor)) {
            return UPDATE_CORRECT + PROFESOR;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Profesor profesor) {
        if (profesorRepositorio.eliminar(profesor)) {
            return DELETE_CORRECT + PROFESOR;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Profesor> buscarTodos() {
        return profesorRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Profesor profesor = profesorRepositorio.buscarPorId(id);
       if (profesorRepositorio.eliminar(profesor)) {
            return DELETE_CORRECT + PROFESOR;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Profesor buscarPorId(Integer id) {
       return profesorRepositorio.buscarPorId(id);
    }
}
