package com.example.bankoflykhvar.dao.impl;

import com.example.bankoflykhvar.dao.RoleDao;
import com.example.bankoflykhvar.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends DaoImpl<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
