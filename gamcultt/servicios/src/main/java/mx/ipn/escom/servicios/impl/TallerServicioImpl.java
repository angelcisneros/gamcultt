/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Taller;
import mx.ipn.escom.repositorios.TallerRepositorio;
import mx.ipn.escom.servicios.TallerServicio;
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
public class TallerServicioImpl implements TallerServicio{
    
    @Autowired
    TallerRepositorio tallerRepositorio;
    private static final String TALLER = "un taller.#";
    
     @Override
    public String agregar(Taller taller) {
        if (tallerRepositorio.agregar(taller)) {
            return ADD_CORRECT + TALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Taller taller) {
        if (tallerRepositorio.actualizar(taller)) {
            return UPDATE_CORRECT + TALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Taller taller) {
        if (tallerRepositorio.eliminar(taller)) {
            return DELETE_CORRECT + TALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Taller> buscarTodos() {
        return tallerRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Taller taller = tallerRepositorio.buscarPorId(id);
       if (tallerRepositorio.eliminar(taller)) {
            return DELETE_CORRECT + TALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Taller buscarPorId(Integer id) {
       return tallerRepositorio.buscarPorId(id);
    }
}
