/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Sala;
import mx.ipn.escom.repositorios.SalaRepositorio;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lap_christo
 */

@Transactional
@Repository
public class SalaRepositorioImpl implements SalaRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(Sala sala) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(sala);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(Sala sala) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(sala);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(Sala sala) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(sala);
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
    public Sala buscarPorId(Integer id) {
        return (Sala) sessionFactory.getCurrentSession().createCriteria(Sala.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Sala> buscarTodos() {
        return (List<Sala>) sessionFactory.getCurrentSession().createCriteria(Sala.class)
                .createAlias("casa", "c", JoinType.INNER_JOIN)
                .list();
    }
    
    
    
}
