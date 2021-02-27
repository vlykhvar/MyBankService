package com.example.bankoflykhvar.dao.impl;

import com.example.bankoflykhvar.dao.RoleDao;
import com.example.bankoflykhvar.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends DaoImpl<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<Role> getByName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("Select r from Role r"
                    + " where r.roleName = :roleName", Role.class)
                    .setParameter("roleName", roleName)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new RuntimeException("Can't get role " + roleName);
        }
    }
}
