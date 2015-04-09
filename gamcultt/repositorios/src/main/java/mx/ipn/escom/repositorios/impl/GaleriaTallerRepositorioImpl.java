/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaTaller;
import mx.ipn.escom.repositorios.GaleriaTallerRepositorio;
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
public class GaleriaTallerRepositorioImpl implements GaleriaTallerRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(GaleriaTaller galeriaTaller) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(galeriaTaller);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(GaleriaTaller galeriaTaller) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(galeriaTaller);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(GaleriaTaller galeriaTaller) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(galeriaTaller);
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
    public GaleriaTaller buscarPorId(Integer id) {
        return (GaleriaTaller) sessionFactory.getCurrentSession().createCriteria(GaleriaTaller.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<GaleriaTaller> buscarTodos() {
        return (List<GaleriaTaller>) sessionFactory.getCurrentSession().createCriteria(GaleriaTaller.class)
                .list();
    }
    
    
    
}
