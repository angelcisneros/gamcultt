/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios;

import java.util.List;
import mx.ipn.escom.entidades.Usuario;

/**
 *
 * @author Lap_christo
 */
public interface UsuarioServicio {
    String agregar(Usuario usuario);
    String actualizar(Usuario usuario);
    String eliminar(Usuario usuario);
    String eliminar(Integer id);
    
    Usuario buscarPorId(Integer id);
    List<Usuario> buscarTodos();
}
