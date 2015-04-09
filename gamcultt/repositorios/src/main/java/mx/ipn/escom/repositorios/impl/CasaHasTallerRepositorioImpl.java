/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.CasaHasTaller;
import mx.ipn.escom.repositorios.CasaHasTallerRepositorio;
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
public class CasaHasTallerRepositorioImpl implements CasaHasTallerRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(CasaHasTaller casaHasTaller) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(casaHasTaller);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(CasaHasTaller casaHasTaller) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(casaHasTaller);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(CasaHasTaller casaHasTaller) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(casaHasTaller);
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
    public CasaHasTaller buscarPorId(Integer id) {
        return (CasaHasTaller) sessionFactory.getCurrentSession().createCriteria(CasaHasTaller.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<CasaHasTaller> buscarTodos() {
        return (List<CasaHasTaller>) sessionFactory.getCurrentSession().createCriteria(CasaHasTaller.class)
                .list();
    }
    
    
    
}
