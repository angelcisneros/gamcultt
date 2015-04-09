/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.Evento;

/**
 *
 * @author Lap_christo
 */

public interface EventoRepositorio {
    
    Boolean agregar(Evento evento);
    Boolean actualizar(Evento evento);
    Boolean eliminar(Evento evento);
    Boolean eliminar(Integer id);
    
    Evento buscarPorId(Integer id);
    List<Evento> buscarTodos();
    
}
