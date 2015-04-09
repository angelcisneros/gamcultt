/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaCasa;
import mx.ipn.escom.repositorios.GaleriaCasaRepositorio;
import mx.ipn.escom.servicios.GaleriaCasaServicio;
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
public class GaleriaCasaServicioImpl implements GaleriaCasaServicio{
    
    @Autowired
    GaleriaCasaRepositorio galeriaCasaRepositorio;
    private static final String GALERIACASA = "una galeriaCasa.#";
    
     @Override
    public String agregar(GaleriaCasa galeriaCasa) {
        if (galeriaCasaRepositorio.agregar(galeriaCasa)) {
            return ADD_CORRECT + GALERIACASA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(GaleriaCasa galeriaCasa) {
        if (galeriaCasaRepositorio.actualizar(galeriaCasa)) {
            return UPDATE_CORRECT + GALERIACASA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(GaleriaCasa galeriaCasa) {
        if (galeriaCasaRepositorio.eliminar(galeriaCasa)) {
            return DELETE_CORRECT + GALERIACASA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<GaleriaCasa> buscarTodos() {
        return galeriaCasaRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       GaleriaCasa galeriaCasa = galeriaCasaRepositorio.buscarPorId(id);
       if (galeriaCasaRepositorio.eliminar(galeriaCasa)) {
            return DELETE_CORRECT + GALERIACASA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public GaleriaCasa buscarPorId(Integer id) {
       return galeriaCasaRepositorio.buscarPorId(id);
    }
}
