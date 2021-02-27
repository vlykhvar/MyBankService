package com.example.bankoflykhvar.dao.impl;

import com.example.bankoflykhvar.dao.UserDao;
import com.example.bankoflykhvar.model.User;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp extends DaoImpl<User> implements UserDao {
    public UserDaoImp(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<User> findById(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("Select u from User u"
                    + " join fetch u.roles where u.id = :userId", User.class)
                    .setParameter("userId", userId)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new RuntimeException("Can't get user on id " + userId);
        }
    }

    @Override
    public void update(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert "
                    + user.getClass().getName()
                    + " entity " + user, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<User> findByPhoneNumber(String phoneNumber) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("Select u from User u"
                    + " join fetch u.roles where u.phoneNumber = :phoneNumber", User.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .uniqueResultOptional();
        }
    }

    @Override
    public boolean removeUser(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            User user = session.load(User.class, id);
            session.remove(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't delete user by id: "
                    + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
