/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Clase;
import mx.ipn.escom.repositorios.ClaseRepositorio;
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
public class ClaseRepositorioImpl implements ClaseRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(Clase clase) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(clase);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(Clase clase) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(clase);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(Clase clase) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(clase);
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
    public Clase buscarPorId(Integer id) {
        return (Clase) sessionFactory.getCurrentSession().createCriteria(Clase.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Clase> buscarTodos() {
        return (List<Clase>) sessionFactory.getCurrentSession().createCriteria(Clase.class)
                .list();
    }
    
    
    
}
