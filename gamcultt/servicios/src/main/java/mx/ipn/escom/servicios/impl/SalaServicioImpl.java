/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Sala;
import mx.ipn.escom.repositorios.SalaRepositorio;
import mx.ipn.escom.servicios.SalaServicio;
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
public class SalaServicioImpl implements SalaServicio{
    
    @Autowired
    SalaRepositorio salaRepositorio;
    private static final String SALA = "un sala.#";
    
     @Override
    public String agregar(Sala sala) {
        if (salaRepositorio.agregar(sala)) {
            return ADD_CORRECT + SALA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Sala sala) {
        if (salaRepositorio.actualizar(sala)) {
            return UPDATE_CORRECT + SALA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Sala sala) {
        if (salaRepositorio.eliminar(sala)) {
            return DELETE_CORRECT + SALA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Sala> buscarTodos() {
        return salaRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Sala sala = salaRepositorio.buscarPorId(id);
       if (salaRepositorio.eliminar(sala)) {
            return DELETE_CORRECT + SALA;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Sala buscarPorId(Integer id) {
       return salaRepositorio.buscarPorId(id);
    }
}
