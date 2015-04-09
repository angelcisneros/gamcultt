/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Propuesta;
import mx.ipn.escom.repositorios.PropuestaRepositorio;
import mx.ipn.escom.servicios.PropuestaServicio;
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
public class PropuestaServicioImpl implements PropuestaServicio{
    
    @Autowired
    PropuestaRepositorio propuestaRepositorio;
    private static final String PROPUESTA = "un propuesta.#";
    
     @Override
    public String agregar(Propuesta propuesta) {
        if (propuestaRepositorio.agregar(propuesta)) {
            return ADD_CORRECT + PROPUESTA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Propuesta propuesta) {
        if (propuestaRepositorio.actualizar(propuesta)) {
            return UPDATE_CORRECT + PROPUESTA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Propuesta propuesta) {
        if (propuestaRepositorio.eliminar(propuesta)) {
            return DELETE_CORRECT + PROPUESTA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Propuesta> buscarTodos() {
        return propuestaRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Propuesta propuesta = propuestaRepositorio.buscarPorId(id);
       if (propuestaRepositorio.eliminar(propuesta)) {
            return DELETE_CORRECT + PROPUESTA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Propuesta buscarPorId(Integer id) {
       return propuestaRepositorio.buscarPorId(id);
    }
}
