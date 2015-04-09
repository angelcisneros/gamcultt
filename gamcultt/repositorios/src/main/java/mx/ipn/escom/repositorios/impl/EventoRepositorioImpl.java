/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.repositorios.impl;

import java.util.List;
import mx.ipn.escom.entidades.Evento;
import mx.ipn.escom.repositorios.EventoRepositorio;
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
public class EventoRepositorioImpl implements EventoRepositorio{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Boolean agregar(Evento evento) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().save(evento);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean actualizar(Evento evento) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().update(evento);
            guardado = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return guardado;
    }

    @Override
    public Boolean eliminar(Evento evento) {
        Boolean guardado = null;
        try {
            sessionFactory.getCurrentSession().delete(evento);
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
    public Evento buscarPorId(Integer id) {
        return (Evento) sessionFactory.getCurrentSession().createCriteria(Evento.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Evento> buscarTodos() {
        return (List<Evento>) sessionFactory.getCurrentSession().createCriteria(Evento.class)
                .list();
    }
    
    
    
}
