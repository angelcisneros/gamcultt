/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Clase;
import mx.ipn.escom.repositorios.ClaseRepositorio;
import mx.ipn.escom.servicios.ClaseServicio;
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
public class ClaseServicioImpl implements ClaseServicio{
    
    @Autowired
    ClaseRepositorio claseRepositorio;
    private static final String CLASE = "un clase.#";
    
     @Override
    public String agregar(Clase clase) {
        if (claseRepositorio.agregar(clase)) {
            return ADD_CORRECT + CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Clase clase) {
        if (claseRepositorio.actualizar(clase)) {
            return UPDATE_CORRECT + CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Clase clase) {
        if (claseRepositorio.eliminar(clase)) {
            return DELETE_CORRECT + CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Clase> buscarTodos() {
        return claseRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Clase clase = claseRepositorio.buscarPorId(id);
       if (claseRepositorio.eliminar(clase)) {
            return DELETE_CORRECT + CLASE;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Clase buscarPorId(Integer id) {
       return claseRepositorio.buscarPorId(id);
    }
}
