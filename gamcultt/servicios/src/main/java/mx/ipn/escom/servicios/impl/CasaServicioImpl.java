/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Casa;
import mx.ipn.escom.repositorios.CasaRepositorio;
import mx.ipn.escom.servicios.CasaServicio;
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
public class CasaServicioImpl implements CasaServicio{
    
    @Autowired
    CasaRepositorio casaRepositorio;
    private static final String CASA = "un casa.#";
    
     @Override
    public String agregar(Casa casa) {
        if (casaRepositorio.agregar(casa)) {
            return ADD_CORRECT + CASA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Casa casa) {
        if (casaRepositorio.actualizar(casa)) {
            return UPDATE_CORRECT + CASA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Casa casa) {
        if (casaRepositorio.eliminar(casa)) {
            return DELETE_CORRECT + CASA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Casa> buscarTodos() {
        return casaRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Casa casa = casaRepositorio.busacarPorId(id);
       if (casaRepositorio.eliminar(casa)) {
            return DELETE_CORRECT + CASA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Casa buscarPorId(Integer id) {
       return casaRepositorio.busacarPorId(id);
    }
}
