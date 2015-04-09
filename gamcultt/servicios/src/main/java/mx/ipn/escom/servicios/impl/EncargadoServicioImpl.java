/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Encargado;
import mx.ipn.escom.repositorios.EncargadoRepositorio;
import mx.ipn.escom.servicios.EncargadoServicio;
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
public class EncargadoServicioImpl implements EncargadoServicio{
    
    @Autowired
    EncargadoRepositorio encargadoRepositorio;
    private static final String ENCARGADO = "un encargado.#";
    
     @Override
    public String agregar(Encargado encargado) {
        if (encargadoRepositorio.agregar(encargado)) {
            return ADD_CORRECT + ENCARGADO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Encargado encargado) {
        if (encargadoRepositorio.actualizar(encargado)) {
            return UPDATE_CORRECT + ENCARGADO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Encargado encargado) {
        if (encargadoRepositorio.eliminar(encargado)) {
            return DELETE_CORRECT + ENCARGADO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Encargado> buscarTodos() {
        return encargadoRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Encargado encargado = encargadoRepositorio.buscarPorId(id);
       if (encargadoRepositorio.eliminar(encargado)) {
            return DELETE_CORRECT + ENCARGADO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Encargado buscarPorId(Integer id) {
       return encargadoRepositorio.buscarPorId(id);
    }
}
