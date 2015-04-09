/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Usuario;
import mx.ipn.escom.repositorios.UsuarioRepositorio;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lap_christo
 */

@Transactional
@Repository
public class UsuarioRepositorioImpl implements UsuarioRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(Usuario usuario) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(usuario);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(Usuario usuario) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(usuario);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(Usuario usuario) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(usuario);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return (Usuario) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Usuario> buscarTodos() {
        return (List<Usuario>) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
                .list();
    }
    
    
    
}
