/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Alumno;
import mx.ipn.escom.repositorios.AlumnoRepositorio;
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
public class AlumnoRepositorioImpl implements AlumnoRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(Alumno alumno) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(alumno);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(Alumno alumno) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(alumno);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(Alumno alumno) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(alumno);
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
    public Alumno buscarPorId(Integer id) {
        return (Alumno) sessionFactory.getCurrentSession().createCriteria(Alumno.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Alumno> buscarTodos() {
        return (List<Alumno>) sessionFactory.getCurrentSession().createCriteria(Alumno.class)
                .list();
    }
    
    
    
}
