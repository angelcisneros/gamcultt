/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Taller;
import mx.ipn.escom.repositorios.TallerRepositorio;
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
public class TallerRepositorioImpl implements TallerRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(Taller taller) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(taller);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(Taller taller) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(taller);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(Taller taller) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(taller);
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
    public Taller buscarPorId(Integer id) {
        return (Taller) sessionFactory.getCurrentSession().createCriteria(Taller.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Taller> buscarTodos() {
        return (List<Taller>) sessionFactory.getCurrentSession().createCriteria(Taller.class)
                .list();
    }
    
    
    
}
