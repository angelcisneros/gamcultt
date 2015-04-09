/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Propuesta;
import mx.ipn.escom.repositorios.PropuestaRepositorio;
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
public class PropuestaRepositorioImpl implements PropuestaRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(Propuesta propuesta) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(propuesta);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(Propuesta propuesta) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(propuesta);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(Propuesta propuesta) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(propuesta);
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
    public Propuesta buscarPorId(Integer id) {
        return (Propuesta) sessionFactory.getCurrentSession().createCriteria(Propuesta.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Propuesta> buscarTodos() {
        return (List<Propuesta>) sessionFactory.getCurrentSession().createCriteria(Propuesta.class)
                .list();
    }
    
    
    
}
