/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaEvento;
import mx.ipn.escom.repositorios.GaleriaEventoRepositorio;
import mx.ipn.escom.servicios.GaleriaEventoServicio;
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
public class GaleriaEventoServicioImpl implements GaleriaEventoServicio{
    
    @Autowired
    GaleriaEventoRepositorio galeriaEventoRepositorio;
    private static final String GALERIAEVENTO = "un galeriaEvento.#";
    
     @Override
    public String agregar(GaleriaEvento galeriaEvento) {
        if (galeriaEventoRepositorio.agregar(galeriaEvento)) {
            return ADD_CORRECT + GALERIAEVENTO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(GaleriaEvento galeriaEvento) {
        if (galeriaEventoRepositorio.actualizar(galeriaEvento)) {
            return UPDATE_CORRECT + GALERIAEVENTO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(GaleriaEvento galeriaEvento) {
        if (galeriaEventoRepositorio.eliminar(galeriaEvento)) {
            return DELETE_CORRECT + GALERIAEVENTO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<GaleriaEvento> buscarTodos() {
        return galeriaEventoRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       GaleriaEvento galeriaEvento = galeriaEventoRepositorio.buscarPorId(id);
       if (galeriaEventoRepositorio.eliminar(galeriaEvento)) {
            return DELETE_CORRECT + GALERIAEVENTO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public GaleriaEvento buscarPorId(Integer id) {
       return galeriaEventoRepositorio.buscarPorId(id);
    }
}
