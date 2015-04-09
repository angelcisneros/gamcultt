/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.servicios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Usuario;
import mx.ipn.escom.repositorios.UsuarioRepositorio;
import mx.ipn.escom.servicios.UsuarioServicio;
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
public class UsuarioServicioImpl implements UsuarioServicio{
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    private static final String USUARIO = "un usuario.#";
    
     @Override
    public String agregar(Usuario usuario) {
        if (usuarioRepositorio.agregar(usuario)) {
            return ADD_CORRECT + USUARIO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String actualizar(Usuario usuario) {
        if (usuarioRepositorio.actualizar(usuario)) {
            return UPDATE_CORRECT + USUARIO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public String eliminar(Usuario usuario) {
        if (usuarioRepositorio.eliminar(usuario)) {
            return DELETE_CORRECT + USUARIO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepositorio.buscarTodos();
    }

    @Override
    public String eliminar(Integer id) {
       Usuario usuario = usuarioRepositorio.buscarPorId(id);
       if (usuarioRepositorio.eliminar(usuario)) {
            return DELETE_CORRECT + USUARIO;
        }
        return ERROR_HIBERNATE;
    }

    @Override
    public Usuario buscarPorId(Integer id) {
       return usuarioRepositorio.buscarPorId(id);
    }
}
