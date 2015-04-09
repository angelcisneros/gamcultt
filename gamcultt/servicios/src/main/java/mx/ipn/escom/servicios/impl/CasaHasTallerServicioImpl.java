/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.CasaHasTaller;
import mx.ipn.escom.repositorios.CasaHasTallerRepositorio;
import mx.ipn.escom.servicios.CasaHasTallerServicio;
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
public class CasaHasTallerServicioImpl implements CasaHasTallerServicio{
    
    @Autowired
    CasaHasTallerRepositorio casaHasTallerRepositorio;
    private static final String CASA_TALLER = "un casaHasTaller.#";
    
     @Override
    public String agregar(CasaHasTaller casaHasTaller) {
        if (casaHasTallerRepositorio.agregar(casaHasTaller)) {
            return ADD_CORRECT + CASA_TALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(CasaHasTaller casaHasTaller) {
        if (casaHasTallerRepositorio.actualizar(casaHasTaller)) {
            return UPDATE_CORRECT + CASA_TALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(CasaHasTaller casaHasTaller) {
        if (casaHasTallerRepositorio.eliminar(casaHasTaller)) {
            return DELETE_CORRECT + CASA_TALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<CasaHasTaller> buscarTodos() {
        return casaHasTallerRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       CasaHasTaller casaHasTaller = casaHasTallerRepositorio.buscarPorId(id);
       if (casaHasTallerRepositorio.eliminar(casaHasTaller)) {
            return DELETE_CORRECT + CASA_TALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public CasaHasTaller buscarPorId(Integer id) {
       return casaHasTallerRepositorio.buscarPorId(id);
    }
}
