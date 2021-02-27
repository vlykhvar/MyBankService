package com.example.bankoflykhvar.service.impl;

import com.example.bankoflykhvar.dao.RoleDao;
import com.example.bankoflykhvar.model.Role;
import com.example.bankoflykhvar.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }
}
