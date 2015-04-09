/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.GaleriaCasa;
import mx.ipn.escom.repositorios.GaleriaCasaRepositorio;
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
public class GaleriaCasaRepositorioImpl implements GaleriaCasaRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(GaleriaCasa galeriaCasa) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(galeriaCasa);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(GaleriaCasa galeriaCasa) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(galeriaCasa);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(GaleriaCasa galeriaCasa) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(galeriaCasa);
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
    public GaleriaCasa buscarPorId(Integer id) {
        return (GaleriaCasa) sessionFactory.getCurrentSession().createCriteria(GaleriaCasa.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<GaleriaCasa> buscarTodos() {
        return (List<GaleriaCasa>) sessionFactory.getCurrentSession().createCriteria(GaleriaCasa.class)
                .list();
    }
    
    
    
}
