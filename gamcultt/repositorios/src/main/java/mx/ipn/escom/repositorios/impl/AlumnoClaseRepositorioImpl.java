/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.AlumnoClase;
import mx.ipn.escom.repositorios.AlumnoClaseRepositorio;
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
public class AlumnoClaseRepositorioImpl implements AlumnoClaseRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(AlumnoClase alumnoClase) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(alumnoClase);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(AlumnoClase alumnoClase) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(alumnoClase);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(AlumnoClase alumnoClase) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(alumnoClase);
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
    public AlumnoClase buscarPorId(Integer id) {
        return (AlumnoClase) sessionFactory.getCurrentSession().createCriteria(AlumnoClase.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<AlumnoClase> buscarTodos() {
        return (List<AlumnoClase>) sessionFactory.getCurrentSession().createCriteria(AlumnoClase.class)
                .list();
    }
    
    
    
}
