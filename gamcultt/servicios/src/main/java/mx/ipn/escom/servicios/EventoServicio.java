/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.Evento;

/**
 *
 * @author Lap_christo
 */
public interface EventoServicio {
    String agregar(Evento evento);
    String actualizar(Evento evento);
    String eliminar(Evento evento);
    String eliminar(Integer id);
    
    Evento buscarPorId(Integer id);
    List<Evento> buscarTodos();
}
