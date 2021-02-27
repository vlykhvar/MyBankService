package com.example.bankoflykhvar.dao.impl;

import com.example.bankoflykhvar.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class DaoImpl<T> implements Dao<T> {
    protected final SessionFactory sessionFactory;

    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T add(T t) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
            return t;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert "
                    + t.getClass().getName() + " entity " + t, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
