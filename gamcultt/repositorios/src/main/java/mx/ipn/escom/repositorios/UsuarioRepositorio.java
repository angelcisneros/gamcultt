/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios;

import java.util.List;
import mx.ipn.escom.entidades.Usuario;

/**
 *
 * @author Lap_christo
 */

public interface UsuarioRepositorio {
    
    Boolean agregar(Usuario usuario);
    Boolean actualizar(Usuario usuario);
    Boolean eliminar(Usuario usuario);
    Boolean eliminar(Integer id);
    
    Usuario buscarPorId(Integer id);
    List<Usuario> buscarTodos();
    
}
