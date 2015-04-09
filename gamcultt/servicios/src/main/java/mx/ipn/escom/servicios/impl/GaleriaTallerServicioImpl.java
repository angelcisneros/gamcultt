/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaTaller;
import mx.ipn.escom.repositorios.GaleriaTallerRepositorio;
import mx.ipn.escom.servicios.GaleriaTallerServicio;
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
public class GaleriaTallerServicioImpl implements GaleriaTallerServicio{
    
    @Autowired
    GaleriaTallerRepositorio galeriaTallerRepositorio;
    private static final String GALERIATALLER = "un galeriaTaller.#";
    
     @Override
    public String agregar(GaleriaTaller galeriaTaller) {
        if (galeriaTallerRepositorio.agregar(galeriaTaller)) {
            return ADD_CORRECT + GALERIATALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(GaleriaTaller galeriaTaller) {
        if (galeriaTallerRepositorio.actualizar(galeriaTaller)) {
            return UPDATE_CORRECT + GALERIATALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(GaleriaTaller galeriaTaller) {
        if (galeriaTallerRepositorio.eliminar(galeriaTaller)) {
            return DELETE_CORRECT + GALERIATALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<GaleriaTaller> buscarTodos() {
        return galeriaTallerRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       GaleriaTaller galeriaTaller = galeriaTallerRepositorio.buscarPorId(id);
       if (galeriaTallerRepositorio.eliminar(galeriaTaller)) {
            return DELETE_CORRECT + GALERIATALLER;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public GaleriaTaller buscarPorId(Integer id) {
       return galeriaTallerRepositorio.buscarPorId(id);
    }
}
