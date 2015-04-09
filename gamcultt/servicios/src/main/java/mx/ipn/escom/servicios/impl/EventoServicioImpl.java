/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Evento;
import mx.ipn.escom.repositorios.EventoRepositorio;
import mx.ipn.escom.servicios.EventoServicio;
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
public class EventoServicioImpl implements EventoServicio{
    
    @Autowired
    EventoRepositorio eventoRepositorio;
    private static final String EVENTO = "un evento.#";
    
     @Override
    public String agregar(Evento evento) {
        if (eventoRepositorio.agregar(evento)) {
            return ADD_CORRECT + EVENTO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Evento evento) {
        if (eventoRepositorio.actualizar(evento)) {
            return UPDATE_CORRECT + EVENTO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Evento evento) {
        if (eventoRepositorio.eliminar(evento)) {
            return DELETE_CORRECT + EVENTO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Evento> buscarTodos() {
        return eventoRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Evento evento = eventoRepositorio.buscarPorId(id);
       if (eventoRepositorio.eliminar(evento)) {
            return DELETE_CORRECT + EVENTO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Evento buscarPorId(Integer id) {
       return eventoRepositorio.buscarPorId(id);
    }
}
