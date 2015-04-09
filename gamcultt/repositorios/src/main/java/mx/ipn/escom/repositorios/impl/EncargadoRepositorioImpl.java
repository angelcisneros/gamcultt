/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Encargado;
import mx.ipn.escom.repositorios.EncargadoRepositorio;
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
public class EncargadoRepositorioImpl implements EncargadoRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(Encargado encargado) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(encargado);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(Encargado encargado) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(encargado);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(Encargado encargado) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(encargado);
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
    public Encargado buscarPorId(Integer id) {
        return (Encargado) sessionFactory.getCurrentSession().createCriteria(Encargado.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Encargado> buscarTodos() {
        return (List<Encargado>) sessionFactory.getCurrentSession().createCriteria(Encargado.class)
                .list();
    }
    
    
    
}
