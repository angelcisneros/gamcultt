/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaEvento;
import mx.ipn.escom.repositorios.GaleriaEventoRepositorio;
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
public class GaleriaEventoRepositorioImpl implements GaleriaEventoRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(GaleriaEvento galeriaEvento) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(galeriaEvento);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(GaleriaEvento galeriaEvento) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(galeriaEvento);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(GaleriaEvento galeriaEvento) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(galeriaEvento);
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
    public GaleriaEvento buscarPorId(Integer id) {
        return (GaleriaEvento) sessionFactory.getCurrentSession().createCriteria(GaleriaEvento.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<GaleriaEvento> buscarTodos() {
        return (List<GaleriaEvento>) sessionFactory.getCurrentSession().createCriteria(GaleriaEvento.class)
                .list();
    }
    
    
    
}
