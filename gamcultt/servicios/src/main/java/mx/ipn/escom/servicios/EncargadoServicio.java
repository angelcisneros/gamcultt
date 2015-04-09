/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.Encargado;

/**
 *
 * @author Lap_christo
 */
public interface EncargadoServicio {
    String agregar(Encargado encargado);
    String actualizar(Encargado encargado);
    String eliminar(Encargado encargado);
    String eliminar(Integer id);
    
    Encargado buscarPorId(Integer id);
    List<Encargado> buscarTodos();
}
